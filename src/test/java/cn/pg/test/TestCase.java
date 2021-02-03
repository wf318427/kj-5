package cn.pg.test;

import javassist.*;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ：zhangfei
 * @date ：Created in 2021/1/27 4:17 下午
 */
public class TestCase {


    @Test
    public void test1() {
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
        new Hello().say();
    }

    @Test
    public void test2() {
        ClassPool cp = ClassPool.getDefault();
        cp.appendClassPath(new LoaderClassPath(TestCase.class.getClassLoader()));
        CtClass cc = null;
        try {
            cc = cp.get("cn.pg.test.Hello");
            CtMethod m = cc.getDeclaredMethod("say");
            m.setBody("{" +
                    "System.out.println(\"Hello123\");" +
                    "}");
            Class c = cc.toClass();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Hello().say();
    }

    @Test
    public void test3() {

        new Hello().say1("daddaa".getBytes());
        ClassPool cp = ClassPool.getDefault();
        cp.appendClassPath(new LoaderClassPath(new sun.misc.Launcher().getClassLoader()));
        CtClass cc = null;
        try {
            cc = cp.get("cn.pg.test.Hello");
            CtMethod m = cc.getDeclaredMethod("say1", new CtClass[]{cp.get(byte[].class.getName())});
            CtField ctField = new CtField(cp.get(byte[].class.getName()), "bytes", cc);
            ctField.setModifiers(Modifier.PRIVATE);
            cc.addField(ctField);

            m.setBody("{" +
                    "if($1==null){return ; }" +
                    "$0.bytes=$1;" +
                    "System.out.println(new String($0.bytes));" +
                    "System.out.println($0.bytes.length);" +
                    "}");
            Class c = cc.toClass();
        } catch (Exception e) {
            e.printStackTrace();
        }


        new Hello().say1("喔喔".getBytes());
    }

    @Test
    public void test4() throws IOException {
        String command = "docker ps -a  ";
        int exitValue = -1;

        BufferedReader bufferedReader = null;
        try {
            // command process
            Process process = Runtime.getRuntime().exec(command);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(process.getInputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream));
            // command log
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            // command exit
            process.waitFor();
            exitValue = process.exitValue();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }

            IOUtils.closeQuietly(bufferedReader);
        }

        if (exitValue == 0) {
            System.out.println("success");
        } else {
            System.out.println("failed");
        }
    }

    @Test
    public void test5(){
        TestCase2 testCase2=new TestCase2();
        TestCase3 testCase3=new TestCase3();
    }

}
