package com.liwx.common.exception;

 import com.liwx.common.response.ResponseResult;
 import lombok.extern.slf4j.Slf4j;
 import org.springframework.http.HttpStatus;
 import org.springframework.web.bind.annotation.ExceptionHandler;
 import org.springframework.web.bind.annotation.ResponseStatus;
 import org.springframework.web.bind.annotation.RestControllerAdvice;

 /**
 * @ClassName CommonException
 * @Author Liwx
 * @Description
 * @Date 2023/5/20$ 15:52
 */
@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {
    /**
     * 处理自定义的业务异常
     */

    @ExceptionHandler(value = CommonException.class)
    public ResponseResult bizExceptionHandler(CommonException e) {
        log.error("发生业务异常！ msg: -> ", e);
        log.error(e.getMessage());
        return ResponseResult.failed(e.getCode(), e.getMessage());
    }

    /**
     * 处理空指针的异常
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseResult exceptionHandler(NullPointerException e) {
        log.error("发生空指针异常！ msg: -> ", e);
        return ResponseResult.failed("发生空指针异常!");
    }

    /**
     * 服务器异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult exception(Exception e) {
        log.error("服务器异常！ msg: -> ", e);
        return ResponseResult.failed("服务器异常!");
    }
}


