package com.yeb.server.mapper;

import com.yeb.server.pojo.AdminRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zel
 * @since 2021-07-26
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {
    // 添加操作员
    Integer addRole(@Param("adminId") Integer adminId, @Param("rids") Integer[]
            rids);
}
