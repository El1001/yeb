package com.yeb.server.service;

import com.yeb.server.pojo.MenuRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yeb.server.pojo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zel
 * @since 2021-07-26
 */
public interface IMenuRoleService extends IService<MenuRole> {
        // 更新角色权限菜单
    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
