package org.example.middleware;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LogFilter implements Filter {
    private final Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        logger.info("{} {}", httpRequest.getRequestURI(), httpRequest.getMethod());
        chain.doFilter(request, response);
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        logger.info("{} {}, {}", httpRequest.getRequestURI(), httpRequest.getMethod(), httpResponse.getStatus());
    }
}