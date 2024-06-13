package com.liwx.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @ClassName TokenConfig
 * @Author Liwx
 * @Description
 * @Date 2024/4/28$ 15:00
 */
@Component
public class TokenConfig {
    @Autowired
    DataSource mDataSource;

    @Bean
    public TokenStore mTokenStore() {
        return new JdbcTokenStore(mDataSource);
    }
}
