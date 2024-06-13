package com.liwx.orderclient;

import com.liwx.common.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@ComponentScan
@FeignClient(contextId = "orderClient", name = BaseFacade.FEIGN_NAME)
public interface OrderClient {
    @GetMapping("order/findOrder/{id}")
    ResponseResult<Object> findOrder(@PathVariable String id);

}
