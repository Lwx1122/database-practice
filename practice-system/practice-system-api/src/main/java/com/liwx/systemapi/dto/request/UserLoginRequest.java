package com.liwx.systemapi.dto.request;

 import lombok.Data;
import org.springframework.validation.annotation.Validated;

/**
 * @ClassName UserLoginRequest
 * @Author Liwx
 */
@Data
@Validated
public class UserLoginRequest {
     private String account;
    private String password;
}
