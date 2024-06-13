package com.liwx.orderclient;

/**
 * @ClassName BaseFacade
 * @Author Liwx
 * @Description
 * @Date 2023/12/28$ 16:07
 */
public class BaseFacade {
    public static final String FEIGN_URL = "${dev.feign.order.url:}";
    public static final String FEIGN_NAME = "practice-order";
}
