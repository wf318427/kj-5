package cn.pg.controller;

import cn.pg.dao.EmpDao;
import cn.pg.dto.Person;
import cn.pg.entity.Emp;
import cn.pg.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ：zhangfei
 * @date ：Created in 2021/1/27 2:22 下午
 */


@Slf4j
@RestController
public class LoginController {


    @Resource
    ThreadPoolExecutor executor;

    @Autowired
    PersonService personService;

    @Resource
    EmpDao empDao;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String hello() {
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> personService.getPerson());
        }
        return "hello";
    }

    @PostMapping("/hello1")
    public Person hello1(@RequestBody Person person) {
        return person;
    }

    @GetMapping("hello2")
    public Emp selectById(Long id) {
        String s=restTemplate.getForObject("http://www.baidu.com",String.class);
        log.info(s);
        return empDao.selectById(id);

    }

}
