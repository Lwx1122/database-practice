package com.liwx.orderweb.controller;

import com.liwx.common.response.ResponseResult;
import com.liwx.orderclient.OrderClient;
import com.liwx.orderweb.service.TestService;
import com.liwx.systemapi.dto.response.UserInfo;
import com.liwx.systemclient.client.UserSystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName OrderController
 * @Author Liwx
 * @Description
 * @Date 2023/12/28 16:24
 */

@RestController
public class OrderController implements OrderClient {
    @Autowired
    TestService mTestService;

    @Autowired
    UserSystemClient userClient;


    @GetMapping("order/test")
    public String getTest() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserInfo admin = userClient.findUserByCode("admin").getData();
        return admin.getName();
    }

    @Override
    public ResponseResult<Object> findOrder(String id) {
        return ResponseResult.success("test" + id);
    }


}
