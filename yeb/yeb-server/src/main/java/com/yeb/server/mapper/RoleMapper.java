package com.yeb.server.mapper;

import com.yeb.server.pojo.Role;
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
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> getRoles(Integer adminId);
}
