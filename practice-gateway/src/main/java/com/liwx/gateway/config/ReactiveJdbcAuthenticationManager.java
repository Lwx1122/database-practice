//package com.liwx.gateway.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.ReactiveAuthenticationManager;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.common.OAuth2AccessToken;
//import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
//import org.springframework.security.oauth2.server.resource.BearerTokenAuthenticationToken;
//import org.springframework.stereotype.Component;
//import reactor.core.publisher.Mono;
//
//import javax.sql.DataSource;
//
//@Slf4j
//@Component
//public class ReactiveJdbcAuthenticationManager implements ReactiveAuthenticationManager {
//
//    @Autowired
//    private TokenStore tokenStore;
//
//
//
//    @Override
//    public Mono<Authentication> authenticate(Authentication authentication) {
//        return Mono.justOrEmpty(authentication)
//                .filter(a -> a instanceof BearerTokenAuthenticationToken)
//                .cast(BearerTokenAuthenticationToken.class)
//                .map(BearerTokenAuthenticationToken::getToken)
//                .flatMap((accessToken ->{
//                    log.info("accessToken is :{}",accessToken);
//                    OAuth2AccessToken oAuth2AccessToken = this.tokenStore.readAccessToken(accessToken);
//                    //根据access_token从数据库获取不到OAuth2AccessToken
//                    if(oAuth2AccessToken == null){
//                        return Mono.error(new InvalidTokenException("invalid access token,please check"));
//                    }else if(oAuth2AccessToken.isExpired()){
//                        return Mono.error(new InvalidTokenException("access token has expired,please reacquire token"));
//                    }
//
//                    OAuth2Authentication oAuth2Authentication =this.tokenStore.readAuthentication(accessToken);
//                    if(oAuth2Authentication == null){
//                        return Mono.error(new InvalidTokenException("Access Token 无效!"));
//                    }else {
//                        return Mono.just(oAuth2Authentication);
//                    }
//                })).cast(Authentication.class);
//    }
//
//
//}