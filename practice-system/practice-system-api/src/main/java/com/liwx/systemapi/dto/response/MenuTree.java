package com.liwx.systemapi.dto.response;

import lombok.Data;

import java.util.List;

/**
 * @ClassName MenuTree
 * @Author Liwx
 * @Description
 * @Date 2023/6/5$ 13:21
 */
@Data
public class MenuTree {
    private Integer id;
    private String name;
    private Integer parentId;
    private List<MenuTree> childs;
}
