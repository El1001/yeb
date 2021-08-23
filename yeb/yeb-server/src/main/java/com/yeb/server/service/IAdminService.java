package com.yeb.server.service;

import com.yeb.server.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yeb.server.pojo.RespBean;
import com.yeb.server.pojo.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zel
 * @since 2021-07-26
 */
public interface IAdminService extends IService<Admin> {
    /**
     * 登录返回token
     *
     * @param username
     * @param password
     * @return
     */
    RespBean login(String username, String password, String code, HttpServletRequest request);

    /**
     * 根据用户名获取用户
     *
     * @param username
     */
    Admin getAdminByUserName(String username);

    //根据用户id查询角色列表
    List<Role> getRoles(Integer adminId);

    //获得所有操作员
    List<Admin> getAllAdmins(String keywords);
    //更新操作员角色
    RespBean updateAdminRole(Integer adminId, Integer[] rids);
    /**
     * 更新用户密码
     *
     * @param oldPass
     * @param pass
     * @param adminId
     * @return
     */
    RespBean updatePassword(String oldPass, String pass, Integer adminId);
}
