package cn.pg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：zhangfei
 * @date ：Created in 2021/1/27 2:22 下午
 */

@RestController
public class LoginController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
