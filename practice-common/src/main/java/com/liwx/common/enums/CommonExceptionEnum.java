package com.liwx.common.enums;



/**
 * @ClassName CommonException
 * @Author Liwx
 * @Description
 * @Date 2023/5/21$ 14:54
 */

public enum CommonExceptionEnum   {
    user_login_error("501", "用户名或密码错误"),
    session_empty("401", "认证异常"),
    empty_error("501", "数据异常");
    public String code;
    public String message;
    CommonExceptionEnum(String code, String message)
    {
        this.code = code;
        this.message = message;
    }
    public String getCode(){
        return this.code;
    }
    public String getMessage() {
        return this.message;
    }
}
