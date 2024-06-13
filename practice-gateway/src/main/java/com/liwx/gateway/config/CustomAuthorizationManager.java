package com.liwx.gateway.config;

//@Component
//public class CustomAuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {
//
//    @Override
//    public Mono<AuthorizationDecision> check(Mono<Authentication> authentication, AuthorizationContext context) {
//        return authentication
//                .map(auth -> auth.isAuthenticated() && hasPermission(auth))
//                .map(AuthorizationDecision::new);
//    }
//
//    private boolean hasPermission(Authentication authentication) {
//        // 在这里编写您的权限验证逻辑
//        // 检查当前用户是否具有所需的权限，可以从 Authentication 对象中获取用户信息进行判断
//        return true; // 返回 true 表示有权限，返回 false 表示无权限
//    }
// }
