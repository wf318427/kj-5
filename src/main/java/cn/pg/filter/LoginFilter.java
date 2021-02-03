package cn.pg.filter;

import cn.pg.config.ContentCachingRequestWrapper;
import cn.pg.config.ContentCachingResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：zhangfei
 * @date ：Created in 2021/1/27 4:27 下午
 */

@Component
@WebFilter
@Slf4j
public class LoginFilter extends OncePerRequestFilter {
    /**
     *
     * @param request
     * @param response
     * @param filterChain
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper=new ContentCachingResponseWrapper(response);
        filterChain.doFilter(requestWrapper,responseWrapper);
        logger.info(new String(requestWrapper.getBody()));
    }
}
