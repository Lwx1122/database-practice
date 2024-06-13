package com.liwx.common.exception;

import com.liwx.common.enums.CommonExceptionEnum;
import lombok.Data;

/**
 * @ClassName CommonException
 * @Author Liwx
 * @Description
 * @Date 2023/5/21$ 14:54
 */
@Data
public class CommonException extends RuntimeException {
    private String code = "501";
    private String message;

    public CommonException(String code, String message) {
        super(message);
        this.code = code;
    }

    public CommonException(String message) {

        super(message);
    }

    public CommonException(CommonExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.message = exceptionEnum.getMessage();
        this.code = exceptionEnum.getCode();


    }
}
