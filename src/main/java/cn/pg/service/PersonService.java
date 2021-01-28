package cn.pg.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.bytecode.AnnotationsAttribute;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;

/**
 * @author ：zhangfei
 * @date ：Created in 2021/1/27 3:28 下午
 */
public class PersonService {
    @Autowired
    @JsonFormat
    private String name;

    public void getPerson(){
        System.out.println("get Person");
    }
}