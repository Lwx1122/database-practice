package com.liwx.systemapi.dto.response;

import lombok.Data;

/**
 * @ClassName UserInfo
 * @Author Liwx
 * @Description
 * @Date 2023/11/9$ 14:37
 */
@Data
public class UserInfo {
    private String userCode;
    private String password;
    private String name;
    private String phoneNum;
    private Boolean enabled;
}
