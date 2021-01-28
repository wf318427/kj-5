package cn.pg.config;

import javassist.*;
import junit.framework.TestCase;
import org.apache.catalina.connector.RequestFacade;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;

/**
 * @author ：zhangfei
 * @date ：Created in 2021/1/27 4:29 下午
 */

//@Configuration
@ConditionalOnClass(RequestFacade.class)
public class LoginConfig implements ApplicationRunner {


    /**
     * Callback used to run the bean.
     *
     * @param args incoming application arguments
     * @throws Exception on error
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {


//// 获取class字节池
//        final ClassPool classPool = ClassPool.getDefault();
//        //获取需要修改的class对象，RestTemplate底层使用的是SimpleClientHttpResponse
//        CtClass ctClass = classPool.get("org.springframework.http.client.SimpleClientHttpResponse");
//        // 获取 获取流的方法
//        CtMethod getBody = ctClass.getDeclaredMethod("getBody");
//        // 重写该方法的具体实现
//        String methodBody ="{if(responseStream==null)
//        {java.io.InputStream errorStream = this.connection.getErrorStream();\n" +
//                "this.responseStream = new java.io.BufferedInputStream(errorStream != null ? errorStream : this.connection.getInputStream());" +
//                "}return this.responseStream;}";
////                覆盖原方法方法
//        getBody.setBody(methodBody);

        System.out.println("dasdsds");

        ClassPool cp = ClassPool.getDefault();
        cp.appendClassPath(new LoaderClassPath(TestCase.class.getClassLoader()));
        CtClass cc = null;
            cc = cp.get(RequestFacade.class.getName());

            CtField ctField = new CtField(cp.get("java.lang.Byte"), "bytes", cc);
            ctField.setModifiers(Modifier.PRIVATE);
            cc.addField(ctField);
            CtMethod ctMethod=cc.getDeclaredMethod("getInputStream");
            ctMethod.setBody("{\n" +
                    "        if (this.request == null) {\n" +
                    "            throw new IllegalStateException(sm.getString(\"requestFacade.nullRequest\"));\n" +
                    "        } else {\n" +
                    "            if(bytes==null){\n" +
                    "                bytes=new byte[this.request.getInputStream().available()];\n" +
                    "                this.request.getInputStream().read(bytes);\n" +
                    "            }\n" +
                    "\n" +
                    "            return new RequestCachingInputStream(bytes);\n" +
                    "        }\n" +
                    "    }");
             cc.toClass();

    }

}
