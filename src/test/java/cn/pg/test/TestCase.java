package cn.pg.test;

import javassist.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @author ：zhangfei
 * @date ：Created in 2021/1/27 4:17 下午
 */
public class TestCase {

    static {
        System.out.println("=========================");
        ClassPool cp = ClassPool.getDefault();
        cp.appendClassPath(new LoaderClassPath(TestCase.class.getClassLoader()));
        CtClass cc = null;
        try {
            cc = cp.get("cn.pg.test.Hello");
            CtMethod m = cc.getDeclaredMethod("say");
            m.insertBefore("{ System.out.println(\"Hello.say():\"); }");
            Class c = cc.toClass();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1(){
        new Hello().say();
    }

    @Test
    public void test2(){
        new Hello().say();
    }
}
