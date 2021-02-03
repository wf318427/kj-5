package cn.pg.test;

import cn.pg.dto.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

/**
 * @author ：zhangfei
 * @date ：Created in 2021/1/30 11:44 下午
 */


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestCase1 {

    @SpyBean
    RestTemplate restTemplate;

    @Test
    public void test(){
        String url="http://localhost:20000/hello1?";

        doReturn(new Person().setName("二狗"))
                .when(restTemplate).postForObject(Mockito.anyString(),Mockito.any(),Mockito.any(),Mockito.anyMap());
        Person person=restTemplate.postForObject(url,null,Person.class,new HashMap(){{put("name","cc");}});
        System.out.println(person);
    }
}
