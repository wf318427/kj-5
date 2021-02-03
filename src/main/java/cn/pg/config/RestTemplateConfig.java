package cn.pg.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import java.nio.charset.Charset;

/**
 * @author ：zhangfei
 * @date ：Created in 2021/1/30 11:40 下午
 */

@Configuration
@Slf4j
public class RestTemplateConfig {
    @Bean
    public RestTemplate  restTemplate(){
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.setRequestFactory(buildRequestFactory());
        restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(Charset.forName("UTF-8")));
        restTemplate.getInterceptors().add((request, body, execution) -> {
            ClientHttpResponse response= execution.execute(request,body);
            CustomerClientHttpResponseWrapper responseWrapper=new CustomerClientHttpResponseWrapper(response);
            log.info("返回数据: {}",IOUtils.toString(responseWrapper.getBody()));
            return responseWrapper;
        });
        return restTemplate;
    }

    private ClientHttpRequestFactory buildRequestFactory() {
        HttpComponentsClientHttpRequestFactory  factory=new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(60*1000);
        factory.setReadTimeout(60*1000);
        return factory;
    }
}
