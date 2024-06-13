package com.liwx.systemclient.client;

import com.liwx.common.response.ResponseResult;
import com.liwx.systemapi.dto.response.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@ComponentScan
@FeignClient(contextId = "userClient", name = BaseFacade.FEIGN_NAME, url = BaseFacade.FEIGN_URL)
public interface UserSystemClient {
    @GetMapping("user/findUser/{userCode}")
    ResponseResult<UserInfo> findUserByCode(@PathVariable String userCode);

    @GetMapping("user/findUserByPhone/{phoneNum}")
    ResponseResult<UserInfo> findUserByPhone(@PathVariable String phoneNum);

}
