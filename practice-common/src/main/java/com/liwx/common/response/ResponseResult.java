package com.liwx.common.response;

import lombok.Data;

/**
 * @ClassName ResponseResult
 * @Author Liwx
 * @Description
 * @Date 2023/5/20$ 15:58
 */
@Data
public class ResponseResult<T> {
    private String code;
    private String message;
    private T data;
    static final String successCode = "200";
    static final String successMessage = "操作成功";
    static final String failCode = "500";
    static final String failMessage = "操作失败";

    public ResponseResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<T>(successCode, successMessage, data);
    }

    public static <T> ResponseResult<T> success(String message, T data) {
        return new ResponseResult<T>(successCode, message, data);
    }

    public static <T> ResponseResult<T> failed(T data) {
        return new ResponseResult<T>(failCode, failMessage, data);
    }

    public static <T> ResponseResult<T> failed(String message, T data) {
        return new ResponseResult<T>(failCode, message, data);
    }
    public static <T> ResponseResult<T> failed(String code ,String message) {
        return new ResponseResult<T>(code, message, null);
    }
    public static <T> ResponseResult<T> success() {
        return new ResponseResult<T>(successCode, successMessage, null);
    }

    public static <T> ResponseResult<T> failed() {
        return new ResponseResult<T>(failCode, failMessage, null);
    }


}
