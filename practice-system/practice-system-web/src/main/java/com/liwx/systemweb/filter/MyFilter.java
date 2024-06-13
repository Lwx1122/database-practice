package com.liwx.eureka.filter;

import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

//@Component
@Slf4j
//@Order(99)
public class MyFilter implements Filter {
    List<String> excludedUris = new ArrayList<>();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String param = initParameterNames.nextElement();
            if (StringUtils.isNotBlank(param)) {
                this.excludedUris .add(filterConfig.getInitParameter(param));
            }
        }
        log.info("==============={}",excludedUris.toString());

    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse
            , FilterChain filterChain)
            throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse);

    }
}