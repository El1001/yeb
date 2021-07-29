package com.yeb.server.mapper;

import com.yeb.server.pojo.MenuRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zel
 * @since 2021-07-26
 */
public interface MenuRoleMapper extends BaseMapper<MenuRole> {
    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}
