package com.liwx.systemweb.filter;

import com.liwx.common.enums.CommonExceptionEnum;
import com.liwx.common.exception.CommonException;

import com.liwx.systemweb.entity.UserEntity;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName Filter
 * @Author Liwx
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request
            , HttpServletResponse response
            , Object handler) throws Exception {
        UserEntity muser = (UserEntity) request.getSession().getAttribute("user");
        if (null == muser || null == muser.getAccount()) {
             throw new CommonException(CommonExceptionEnum.session_empty);
        }
        return true;
    }

}
