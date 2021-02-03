package cn.pg.service;

import cn.pg.dao.EmpDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author ：zhangfei
 * @date ：Created in 2021/2/1 6:44 下午
 */

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonServiceTest {

    @SpyBean
    PersonService personService;

    @Resource
    EmpDao empDao;
    @Test
    public void getPerson() {
        personService.getPerson();
    }



}