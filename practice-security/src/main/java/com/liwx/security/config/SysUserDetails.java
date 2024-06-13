package com.liwx.security.config;

import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @ClassName UserDetailServiceimpl
 * @Author Liwx
 * @Description
 * @Date 2023/7/6  16:36
 */
@Data
@Component
public class SysUserDetails implements UserDetails {


    /**
     * 默认字段
     */
    private String username;
    /**
     * 扩展字段
     */

    private String phoneNum;
    private String password;

    /**
     * 扩展字段
     */
    private String userCode;

    private Boolean enabled;
    private Collection<? extends GrantedAuthority> authorities;
    public  String roles="All";


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(StringUtils.isEmpty(roles)){
            roles="All";
        }
        return Arrays.stream(roles.split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toSet());

    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
