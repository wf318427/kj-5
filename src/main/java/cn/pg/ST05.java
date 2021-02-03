package cn.pg;

import cn.pg.dto.Person;
import javassist.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import sun.misc.Launcher;

/**
 * @author ：zhangfei
 * @date ：Created in 2021/1/27 2:20 下午
 */

@SpringBootApplication
@MapperScan({"cn.pg.dao"})
@EnableAspectJAutoProxy
public class ST05 {
    public static void main(String[] args) {

        SpringApplication.run(ST05.class,args);
    }
}
