package cn.pg.dto;

import javassist.*;
import lombok.Data;

import java.lang.reflect.Method;

/**
 * @author ：zhangfei
 * @date ：Created in 2021/1/27 3:01 下午
 */

@Data
public class Person {
    private String name;

    public void personFly(){
        System.out.println("我要起飞");
    }

    public static void main(String[] args) throws Exception {
        ClassPool cp = ClassPool.getDefault();
        cp.appendClassPath(new LoaderClassPath(Person.class.getClassLoader()));
        CtClass cc = cp.get("cn.pg.dto.Person");
        CtMethod m = cc.getDeclaredMethod("personFly");
        m.insertBefore("{ System.out.println(\"Person.personFly():\"); }");
        Class c = cc.toClass();
        Person h = (Person)c.newInstance();
        h.personFly();

    }
}
