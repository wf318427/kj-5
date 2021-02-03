package cn.pg.service;

import cn.pg.dao.EmpDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author ：zhangfei
 * @date ：Created in 2021/2/1 6:48 下午
 */

@Service
@Slf4j
public class StudentServiceTest {

    @Autowired
    StudentService studentService;

    @SpyBean
    EmpDao empDao;
}