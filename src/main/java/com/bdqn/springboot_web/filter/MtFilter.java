package com.bdqn.springboot_web.filter;

import javax.servlet.*;
import java.io.IOException;


/**
 * @author 贺威
 * @create 2018-12-01 18:26
 */
public class MtFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(" 1");
    }

    @Override
    public void destroy() {
        System.out.println("3");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(" 2");
        chain.doFilter(request, response);

    }
}
