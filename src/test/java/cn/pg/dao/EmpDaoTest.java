package cn.pg.dao;

import cn.pg.entity.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author ：zhangfei
 * @date ：Created in 2021/1/30 1:34 上午
 */

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class EmpDaoTest {

    @Resource
    EmpDao empDao;
    @Test
    public void test() {
        Emp emp=empDao.selectById(1L);
        System.out.println(emp);
    }

    @Test
    @Transactional
    public void test1() {
        Emp emp=empDao.selectById(1L);
        System.out.println(emp);
    }

//    @Test
//    public void test5(){
//        TestCase2 testCase2=new TestCase2();
//        TestCase3 testCase3=new TestCase3();
//    }
}