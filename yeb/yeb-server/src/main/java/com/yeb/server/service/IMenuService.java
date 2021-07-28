package com.yeb.server.service;

import com.yeb.server.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zel
 * @since 2021-07-26
 */
public interface IMenuService extends IService<Menu> {
    List<Menu> getMenusByAdminId();

    List<Menu> getAllMenusWithRole();
}
