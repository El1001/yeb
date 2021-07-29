package com.yeb.server.mapper;

import com.yeb.server.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zel
 * @since 2021-07-26
 */
public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> getMenusByAdminId(Integer id);
// 通过角色获取菜单列表
    List<Menu> getMenusWithRole();
    // 获取所有菜单
    List<Menu> getAllMenus();
}
