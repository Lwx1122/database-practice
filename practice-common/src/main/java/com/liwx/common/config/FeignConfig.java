package com.liwx.common.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName FeignConfig
 * @Author Liwx
 * @Description
 * @Date 2024/4/29$ 14:47
 */
//@Configuration
public class FeignConfig implements RequestInterceptor {
    @Autowired
    PatternsConfig mPatternsConfig;
    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        HttpServletRequest request = requestAttributes.getRequest();
        String authorization = String.valueOf(request.getAttribute("Authorization"));
        if(StringUtils.isNotBlank(authorization) && !CollectionUtils.isEmpty(
                mPatternsConfig.getDetail())) {
            String url = request.getRequestURL().toString();
            if (mPatternsConfig.getDetail().contains(url)) {
                requestTemplate.header("Authorization", authorization);
            }
        }
    }
}
