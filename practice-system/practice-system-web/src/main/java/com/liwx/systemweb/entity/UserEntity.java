package com.liwx.systemweb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@TableName("t_user")
public class UserEntity implements Serializable {
    private Integer id;

    private String account;

    private String name;

  //  private String position;

   // private String sex;

 //   private Date birthday;

    private String status;

    private String password;

//    private String cardId;

 //   private String cardType;

    private String phoneNum;


}