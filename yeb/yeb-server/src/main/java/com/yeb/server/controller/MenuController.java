package com.yeb.server.controller;


import com.yeb.server.pojo.Menu;
import com.yeb.server.service.IMenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zel
 * @since 2021-07-26
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    IMenuService menuService;

    @ApiOperation(value = "通过用户Id读取菜单")
    @GetMapping("/menu")
    public List<Menu> getMenuByAdminId() {
        return menuService.getMenusByAdminId();
    }
}
