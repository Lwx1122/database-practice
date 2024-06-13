//package com.liwx.security.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//
//@Configuration
//@EnableAuthorizationServer
//public class InMemoryAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
//    @Autowired
//    AuthenticationManager authenticationManager;
//    @Autowired
//    PasswordEncoder passwordEncoder;
//    @Autowired
//    TokenStore mTokenStore;
//
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients
//                .inMemory()
//                .withClient("clientC")
//                .secret(passwordEncoder.encode("123456"))
//                .authorizedGrantTypes("authorization_code", "refresh_token", "password", "client_credentials")
//                .scopes("read", "write")
//                .redirectUris("https://www.baidu.com")
//                .resourceIds("resource")
//                .accessTokenValiditySeconds(3600)
//                .refreshTokenValiditySeconds(3600 * 24);
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.tokenStore(mTokenStore).authenticationManager(authenticationManager);
//    }
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//    security.checkTokenAccess("permitAll");
//  //  security.checkTokenAccess();
//    security.allowFormAuthenticationForClients();
//    }
//}
