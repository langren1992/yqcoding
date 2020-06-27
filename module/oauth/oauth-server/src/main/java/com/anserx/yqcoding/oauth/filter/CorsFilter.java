package com.anserx.yqcoding.oauth.filter;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * @title: CorsFilter
 * @description: 跨域拦截器
 * @auther: zengrui
 * @time: 2019/1/20 11:56
 **/
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter extends OncePerRequestFilter {

    /***
     * @title: doFilterInternal
     * @description: 添加拦截器
     * @param: request
     * @param: response
     * @param: filterChain
     * @return: void
     * @auther: zengrui
     * @time: 2018/12/14 10:41
     **/
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 域名不能为* 需要根据请求设置
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        //是否允许后续请求携带认证信息（cookies）,该值只能是true,否则不返回
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,Authorization,Token");
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            // 3. 校验通过，就放行
            filterChain.doFilter(request, response);
        }

    }

}
