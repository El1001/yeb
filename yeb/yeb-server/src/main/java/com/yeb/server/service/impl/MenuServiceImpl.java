package com.yeb.server.service.impl;

import com.yeb.server.pojo.Admin;
import com.yeb.server.pojo.Menu;
import com.yeb.server.mapper.MenuMapper;
import com.yeb.server.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zel
 * @since 2021-07-26
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    MenuMapper menuMapper;
    @Override
    public List<Menu> getMenusByAdminId() {

        // Spring框架借助ThreadLocal来保存和传递用户登录信息。我们通常是使用下面这段代码，来获取保存在ThreadLocal中的用户信息。
        return menuMapper.getMenusByAdminId(((Admin)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    };

}
