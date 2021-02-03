package cn.pg.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author ：zhangfei
 * @date ：Created in 2021/2/1 10:45 上午
 */

//@Component
//@Aspect
@Slf4j
public class RequestLogAspect {

    @Around(value = "execution(* cn.pg.controller..*.*(..))")
    public void ss(ProceedingJoinPoint point)  {


        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        try {
            log.info(request.getRequestURL().toString());
            log.info(request.getMethod());

            Signature signature = point.getSignature();
            if (signature instanceof MethodSignature) {
                MethodSignature methodSignature = (MethodSignature) signature;
                String[] properties = methodSignature.getParameterNames();
                log.info(Arrays.toString(properties));
            }
            point.proceed();
            log.info("请求后");
            if (signature instanceof MethodSignature) {
                MethodSignature methodSignature = (MethodSignature) signature;
                // 被切的方法
                Method method = methodSignature.getMethod();
                // 返回类型
                Class<?> methodReturnType = method.getReturnType();
                // 实例化
                Object o = methodReturnType.newInstance();
            }
        }catch (Throwable e){
            log.error("e : {}",e);
        }



    }
}
