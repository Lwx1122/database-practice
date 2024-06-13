package com.liwx.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@ConfigurationProperties("oauth")
@Data
public class OAuth2Config  {


    private String checkTokenUri;


    private String clientId;


    private String clientSecret;

    String resourceId;
    String tokenUri;
}