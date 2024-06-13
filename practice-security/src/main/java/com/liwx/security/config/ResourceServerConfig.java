//package com.liwx.security.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//
///**
// * @ClassName ResourceServerConfig
// * @Author Liwx
// * @Description
// * @Date 2024/4/22$ 15:55
// */
//@Configuration
//@EnableResourceServer
//public class ResourceServerConfig
//        extends ResourceServerConfigurerAdapter
//{
//    @Autowired
//    TokenStore mTokenStore;
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        resources.tokenStore(mTokenStore);
//    }
//
//
//}
