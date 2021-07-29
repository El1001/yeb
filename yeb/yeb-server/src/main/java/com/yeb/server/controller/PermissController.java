package com.yeb.server.controller;

import com.yeb.server.pojo.RespBean;
import com.yeb.server.pojo.Role;
import com.yeb.server.service.IRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 权限组
@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {
    @Autowired
    private IRoleService roleService;

    @ApiOperation(value = "获取所有角色")
    @GetMapping("/")
    public List<Role> getAllRoles() {
        return roleService.list();
    }

    @ApiOperation(value = "添加角色")
    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role) {
        // 添加前缀
        if (!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());
        }
        if (roleService.save(role)) {
            return RespBean.success("添加成功!");
        } else
            return RespBean.error("添加失败!");

    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("/role/{rid}")
    public RespBean deleteRole(@PathVariable Integer rid) {
        if (roleService.removeById(rid)) {
            return RespBean.success("删除成功!");
        } else
            return RespBean.error("删除失败!");
    }
}