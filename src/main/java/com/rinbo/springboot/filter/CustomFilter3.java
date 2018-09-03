package com.rinbo.springboot.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName="filter3",urlPatterns="/*")
@Slf4j
public class CustomFilter3 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter3 初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("doFilter3 请求处理");
        //链路 直接传给下一个过滤器
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("filter3 销毁");
    }
}
