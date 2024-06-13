package com.liwx.orderweb.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter{


    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(  "/user/findUser/**","/order/findOrder/**").permitAll()
                .anyRequest().authenticated() // 其他请求需要认证
                .and()
                .csrf().disable() // 禁用 CSRF
                .httpBasic()
        ;
    }
}
