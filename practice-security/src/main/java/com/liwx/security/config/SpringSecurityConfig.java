package com.liwx.security.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName SpringSecurityConfig
 * @Author Liwx
 * @Description
 * @Date 2024/4/18$ 14:55
 */
@EnableWebSecurity
@Slf4j
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    SysUserDetailServiceImpl mSysUserDetails;
    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 禁用 CSRF
        http .csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/findUser/**").permitAll()
                .anyRequest().authenticated() // 其他请求需要认证
                .and()
                .httpBasic();

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(mSysUserDetails).passwordEncoder(passwordEncoder);
    }

    @Override
    @Bean // 声明为Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers( "/user/findUser/**");
//        super.configure(web);
//    }
}

