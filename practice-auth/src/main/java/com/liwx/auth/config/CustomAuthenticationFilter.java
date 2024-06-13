package com.liwx.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//    @Autowired
//    private   AuthenticationManager authenticationManager;
//
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        try {
//            // 从请求中获取用户名和密码
//            String username = obtainUsername(request);
//            String password = obtainPassword(request);
//
//            // 创建认证令牌
//            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
//
//            // 执行身份验证
//            return authenticationManager.authenticate(authenticationToken);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
//        // 认证成功后的处理逻辑
//        // 可以在这里生成并返回 JWT 等身份验证成功后的信息
//    }
//
//    @Override
//    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
//        // 认证失败后的处理逻辑
//        // 可以在这里返回自定义的错误信息
//    }
//}
