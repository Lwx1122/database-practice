package com.liwx.systemweb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liwx.systemweb.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

}