package com.liwx.systemweb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

 @Data
@TableName("t_menu")
public class  MenuEntity   {
    private Integer id;

    private String name;

    private String status;
    @TableField(value = "parentId")
    private Integer parentId;

    private String url;


}