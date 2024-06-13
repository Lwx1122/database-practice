package com.liwx.orderweb.config;

import com.liwx.common.config.OAuth2Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author:wangchao
 * @date: 2023/5/7-22:30
 * @description: com.sh3h.common.config
 * @Version:1.0
 */
@Configuration
@EnableResourceServer // 标识为资源服务器，请求服务中的资源，就要带着token过来，找不到token或token是无效访问不了资源
@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启方法级别权限控制
public class ResourceConfig   extends ResourceServerConfigurerAdapter
{
    @Autowired
    TokenStore mDataSource;

    @Autowired
    private TokenStore mTokenStore;
    @Autowired
    OAuth2Config authConfig;

    @Bean
    public ResourceServerTokenServices tokenService() {
        // 远程认证服务器进行校验 token 是否有效
        RemoteTokenServices service = new RemoteTokenServices();
        // 请求认证服务器校验的地址，默认情况 这个地址在认证服务器它是拒绝访问，要设置为认证通过可访问
        service.setCheckTokenEndpointUrl(authConfig.getCheckTokenUri());
        service.setClientId(authConfig.getClientId());
        service.setClientSecret(authConfig.getClientSecret());
        return service;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        // 当前资源服务器的资源id，认证服务会认证客户端有没有访问这个资源id的权限，有则可以访问当前服务
        resources.resourceId(authConfig.getResourceId().trim())
                .tokenStore(mTokenStore)
                .tokenServices(tokenService())
        ;
    }
}

