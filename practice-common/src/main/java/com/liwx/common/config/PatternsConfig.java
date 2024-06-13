package com.liwx.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName PatternsConfig
 * @Author Liwx
 * @Description
 * @Date 2023/5/21$ 16:57
 */
@Configuration
@ConfigurationProperties("patterns")
@Data
public class PatternsConfig {
    private List<String> detail;


}
