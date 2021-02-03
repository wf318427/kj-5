package cn.pg.service;

import cn.pg.dao.EmpDao;
import cn.pg.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：zhangfei
 * @date ：Created in 2021/2/1 6:47 下午
 */

@Service
public class StudentService {

    @Autowired
    private EmpDao empDao;
    public void selectById(){
        System.out.println(empDao.selectById(1L));
    }
}
