package com.qf.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class EncodingFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String method = request.getMethod();

        if("GET".equals(method)){
            request.setCharacterEncoding("utf-8");
        }
        filterChain.doFilter(request,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
