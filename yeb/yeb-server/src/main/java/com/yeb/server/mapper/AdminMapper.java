package com.yeb.server.mapper;

import com.yeb.server.pojo.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zel
 * @since 2021-07-26
 */
public interface AdminMapper extends BaseMapper<Admin> {
    //    获取所有操作员
    List<Admin> getAllAdmins(@Param("id") Integer id, @Param("keywords") String keywords);
}
