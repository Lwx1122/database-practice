package com.liwx.systemweb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liwx.common.enums.CommonExceptionEnum;
import com.liwx.common.exception.CommonException;
import com.liwx.systemapi.dto.request.UserLoginRequest;
import com.liwx.systemapi.dto.response.UserInfo;
import com.liwx.systemweb.dao.UserMapper;
import com.liwx.systemweb.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Author Liwx
 */
@Service
public class UserService {
    @Autowired
    UserMapper mUserMapper;


    public UserEntity login(UserLoginRequest user) {
        UserEntity userPO = new UserEntity();
        userPO.setAccount(user.getAccount());
        userPO.setPassword(user.getPassword());
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.setEntity(userPO);
        userPO = mUserMapper.selectOne(queryWrapper);
        if (null == userPO) {
            throw new CommonException(CommonExceptionEnum.user_login_error);
        }
        //   HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        // HttpSession session = request.getSession();
        //   session.setAttribute("user", userPO);
        return userPO;
    }


    public UserInfo findUserByCode(String userCode) {
        UserEntity userPO = new UserEntity();
        userPO.setAccount(userCode);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.setEntity(userPO);
        userPO = mUserMapper.selectOne(queryWrapper);
        if (null == userPO) {
            return null;
        }
        UserInfo target = new UserInfo();
        BeanUtils.copyProperties(userPO, target);
        target.setUserCode(userPO.getAccount());
        target.setEnabled("1".equals(userPO.getStatus()));
        System.out.println(target.getUserCode());
        return target;
    }


    public UserInfo findUserByPhone(String phoneNum) {
        UserEntity userPO = new UserEntity();
        userPO.setPhoneNum(phoneNum);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.setEntity(userPO);
        userPO = mUserMapper.selectOne(queryWrapper);
        UserInfo target = new UserInfo();
        BeanUtils.copyProperties(userPO, target);
        return target;
    }
}
