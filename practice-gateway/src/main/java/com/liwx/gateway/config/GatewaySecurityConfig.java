package com.liwx.gateway.config;

import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

//@Configuration
//@EnableWebFluxSecurity
//public class GatewaySecurityConfig {
//
//    // @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//        return http
//                .authorizeExchange()
//                .pathMatchers("/login", "/user/findUser/**").permitAll() // 允许访问登录页面
//                .anyExchange().authenticated() // 其他请求需要认证
////                .and()
////                .formLogin() // 启用基于表单的登录
////                    .loginPage("/login") // 设置登录页面路径
//                .and()
//                .csrf().disable() // 禁用 CSRF
//                .httpBasic().and().build();
//    }
//}
