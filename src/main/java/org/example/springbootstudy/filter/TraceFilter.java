package org.example.springbootstudy.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.example.springbootstudy.utils.TraceIdUtils;

import java.io.IOException;

@Slf4j
public class TraceFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        try {
            HttpServletRequest servletRequest = (HttpServletRequest) request;
            String gateWayTraceId = servletRequest.getHeader(TraceIdUtils.TRACE_ID_KEY);
            TraceIdUtils.generateTraceId(gateWayTraceId);
            //请求放行
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            log.error("TraceFilter error:{}", e.getMessage());
        } finally {
            //最后移除，否则可能内存泄露
            TraceIdUtils.removeTraceId();
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}