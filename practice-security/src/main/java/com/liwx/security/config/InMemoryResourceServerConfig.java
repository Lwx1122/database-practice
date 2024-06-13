//package com.liwx.security.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//
//@Configuration
//@EnableResourceServer
//public class InMemoryResourceServerConfig extends
//        ResourceServerConfigurerAdapter {
//    @Autowired
//    TokenStore tokenStore;
//
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) {
//        resources.tokenStore(tokenStore); // 配置令牌存储
//        resources.resourceId("resource").stateless(true);
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .requestMatchers(req -> req.mvcMatchers("/auth/**"))
//                .authorizeRequests(req -> req
//                        .antMatchers("/auth/**").permitAll()
//                )
//        //oauth2使用jwt模式，会走接口拿取公钥解密验签
//        ;
//        super.configure(http);
//    }
//
//
//}
//
