package com.yeb.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yeb.server.pojo.MenuRole;
import com.yeb.server.mapper.MenuRoleMapper;
import com.yeb.server.pojo.RespBean;
import com.yeb.server.service.IMenuRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zel
 * @since 2021-07-26
 */
@Service
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements IMenuRoleService {

    @Autowired
    MenuRoleMapper menuRoleMapper;

//@Transactional 是声明式事务管理 编程中使用的注解
    @Override
    @Transactional
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        // 查找是存在 存在则删除再添加
        menuRoleMapper.delete(new QueryWrapper<MenuRole>().eq("rid", rid));
        if (null == mids || 0 == mids.length) {
            return RespBean.success("更新成功！");
        }
        Integer result = menuRoleMapper.insertRecord(rid, mids);
        if (mids.length == result) {
            return RespBean.success("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
}
