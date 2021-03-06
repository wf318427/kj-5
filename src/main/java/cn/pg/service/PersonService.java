package cn.pg.service;


import cn.pg.dao.EmpDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：zhangfei
 * @date ：Created in 2021/1/27 3:28 下午
 */
@Service
@Slf4j
public class PersonService {

    private String name;

    public void getPerson(){

        log.info("get Person");
    }

    @Autowired
    private EmpDao empDao;
    public void selectById(){
        System.out.println(empDao.selectById(1L));
    }
}