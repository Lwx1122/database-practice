package com.liwx.systemweb.controller;

import com.liwx.common.response.ResponseResult;
import com.liwx.systemapi.dto.response.MenuTree;
import com.liwx.systemweb.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MenuController
 * @Author Liwx
 * @Description
 * @Date 2023/6/5$ 13:18
 */
@RequestMapping("menu")
@RestController
public class MenuController {
    @Autowired
    MenuService mMenuService;

    @GetMapping("tree")
    public ResponseResult<MenuTree> findMenuTree() {
        return ResponseResult.success(mMenuService.findMenuTree());
    }
}
