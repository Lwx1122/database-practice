package com.liwx.security.config;


import com.liwx.common.enums.CommonExceptionEnum;
import com.liwx.common.exception.CommonException;
import com.liwx.systemapi.dto.response.UserInfo;
import com.liwx.systemclient.client.UserSystemClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName SysUserDetailService
 * @Author Liwx
 * @Description
 * @Date 2023/7/6$ 16:40
 */
@Component
public class SysUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserSystemClient userSystemClient;
    @Autowired
    PasswordEncoder passwordEncoder;


    /**
     * @return
     * @Author Liwx
     * @Description 用户名不唯一，但是account账户唯一
     * @Date 2023/7/6 16:51
     * @Param
     **/

    public SysUserDetails loadUserByUserCode(String userCode) throws UsernameNotFoundException {
        // 管理端获取用户信息
        SysUserDetails userDetails = this.loadUserByCode(userCode);
        if (!userDetails.isEnabled()) {
            throw new DisabledException("该账户已被禁用!");
        } else if (!userDetails.isAccountNonLocked()) {
            throw new LockedException("该账号已被锁定!");
        } else if (!userDetails.isAccountNonExpired()) {
            throw new AccountExpiredException("该账号已过期!");
        }
        List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(
                userDetails.getUserCode());
        userDetails.setAuthorities(authorityList);
        userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        return userDetails;

    }

    public SysUserDetails loadUserByCode(String userCode) {
        UserInfo userInfo = userSystemClient.findUserByCode(userCode).getData();
        if (null != userInfo && null != userInfo.getUserCode()) {
            SysUserDetails userDetails = new SysUserDetails();
            BeanUtils.copyProperties(userInfo, userDetails);
            return userDetails;
        }
        throw new CommonException(CommonExceptionEnum.empty_error);

    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserInfo userInfo = userSystemClient.findUserByCode(userName).getData();
        if (null != userInfo && null != userInfo.getUserCode()) {
            SysUserDetails userDetails = new SysUserDetails();
            BeanUtils.copyProperties(userInfo, userDetails);
            if (!userDetails.isEnabled()) {
                throw new DisabledException("该账户已被禁用!");
            }
//            else if (!userDetails.isAccountNonLocked()) {
//                throw new LockedException("该账号已被锁定!");
//            } else if (!userDetails.isAccountNonExpired()) {
//                throw new AccountExpiredException("该账号已过期!");
//            }


         //   userDetails.setAuthorities();
            userDetails.setUsername(userInfo.getUserCode());
            userDetails.setPassword(passwordEncoder.encode(userInfo.getPassword()));
            return userDetails;
        }
        throw new CommonException(CommonExceptionEnum.empty_error);
    }

    public UserDetails loadUserByPhoneNum(String phoneNum) throws UsernameNotFoundException {
        // 管理端获取用户信息
        SysUserDetails userDetails = this.loadUserByPhone(phoneNum);
        if (!userDetails.isEnabled()) {
            throw new DisabledException("该账户已被禁用!");
        } else if (!userDetails.isAccountNonLocked()) {
            throw new LockedException("该账号已被锁定!");
        } else if (!userDetails.isAccountNonExpired()) {
            throw new AccountExpiredException("该账号已过期!");
        }
        return userDetails;

    }

    private SysUserDetails loadUserByPhone(String phoneNum) {
        UserInfo userInfo = userSystemClient.findUserByPhone(phoneNum).getData();
        if (null != userInfo && null != userInfo.getUserCode()) {
            SysUserDetails target = new SysUserDetails();
            BeanUtils.copyProperties(userInfo, target);
            return target;
        }
        throw new CommonException(CommonExceptionEnum.empty_error);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    public static void main(String[] args) {
        String encode = new BCryptPasswordEncoder().encode("123456");
        System.out.println(encode);
    }
}
