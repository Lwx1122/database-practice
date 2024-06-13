package com.liwx.systemweb.controller;

import com.liwx.common.response.ResponseResult;
import com.liwx.orderclient.OrderClient;
import com.liwx.systemapi.dto.request.UserLoginRequest;
import com.liwx.systemapi.dto.response.UserInfo;
import com.liwx.systemclient.client.UserSystemClient;
import com.liwx.systemweb.entity.UserEntity;
import com.liwx.systemweb.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName UserController
 * @Author Liwx
 */

@RestController
public class UserController implements UserSystemClient {
    @Autowired
    UserService mUserService;

    @Autowired
    OrderClient mOrderClient;

    @GetMapping("user/getTest")
    public String getTest() {
        System.out.println("-------------------");
        ResponseResult<Object> id = mOrderClient.findOrder("id");
        Object data = id.getData();
        System.out.println("=======" + data.toString());
        return "Hello world";
    }

    @PostMapping("user/login")
    public ResponseResult<UserInfo> login(@RequestBody UserLoginRequest user) {

        if (null == user) {
            return ResponseResult.failed();
        }

        UserEntity login = mUserService.login(user);
        UserInfo target = new UserInfo();
        BeanUtils.copyProperties(login, target);
        return ResponseResult.success(target);
    }

    @PostMapping("user/logout")
    public Boolean logout() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        HttpSession session = request.getSession();
        session.invalidate();
        return true;
    }


    @Override
    public ResponseResult<UserInfo> findUserByCode( String userCode) {
        UserInfo userByCode = mUserService.findUserByCode(userCode);
        return ResponseResult.success(userByCode);
    }

    @Override
    public ResponseResult<UserInfo> findUserByPhone( String phoneNum) {
        UserInfo userByPhone = mUserService.findUserByPhone(phoneNum);
        return ResponseResult.success(userByPhone);
    }



}
