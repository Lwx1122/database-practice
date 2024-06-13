package com.liwx.systemweb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.liwx.systemapi.dto.response.MenuTree;
import com.liwx.systemweb.dao.MenuMapper;
import com.liwx.systemweb.entity.MenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName MenuService
 * @Author Liwx
 * @Description
 * @Date 2023/6/5$ 13:19
 */
@Service
public class MenuService {
    @Autowired
    MenuMapper mMenuMapper;

    public MenuTree findMenuTree() {
        MenuTree menuTree = new MenuTree();
        menuTree.setId(0);
        menuTree.setName("菜单管理");
        menuTree.setParentId(-1);
        MenuEntity menu = new MenuEntity();
        menu.setStatus("1");
        QueryWrapper tQueryWrapper = new QueryWrapper<>();
        tQueryWrapper.setEntity(menu);
        List<MenuEntity> menus = mMenuMapper.selectList(tQueryWrapper);
        List<MenuTree> menuTreeList = findMenuTreeChilds(menuTree.getId(), menus);
        if (!CollectionUtils.isEmpty(menuTreeList)) {
            menuTree.setChilds(menuTreeList);
        }
        return menuTree;
    }

    private List<MenuTree> findMenuTreeChilds(Integer id, List<MenuEntity> menus) {
        List<MenuTree> menuTrees = menus.stream().filter(e -> id.equals(e.getParentId())).map(e -> {

            MenuTree menuTree = new MenuTree();
            menuTree.setParentId(e.getParentId());
            menuTree.setId(e.getId());
            menuTree.setName(e.getName());
            List<MenuTree> menuTreeChilds = findMenuTreeChilds(e.getId(), menus);
            if (!CollectionUtils.isEmpty(menuTreeChilds)) {
                menuTree.setChilds(menuTreeChilds);
            }
            return menuTree;
        }).collect(Collectors.toList());
        return menuTrees;
    }
}

