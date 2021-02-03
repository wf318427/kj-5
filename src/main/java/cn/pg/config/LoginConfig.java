package cn.pg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：zhangfei
 * @date ：Created in 2021/1/27 4:29 下午
 */

@Configuration
public class LoginConfig  {
    @Bean
    public ThreadPoolExecutor  executor(){
        Integer processors=Runtime.getRuntime().availableProcessors();

        ThreadPoolExecutor executor=new ThreadPoolExecutor(processors, processors * 2, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "admin-pool-" + r.hashCode());
            }
        });

        return executor;

    }
}
