package com.yeb.server.service;

import com.yeb.server.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yeb.server.pojo.RespBean;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zel
 * @since 2021-07-26
 */
public interface IAdminService extends IService<Admin> {
/**
* 登录返回token
* @param username
* @param password
* @return
*/
 RespBean login(String username, String password, HttpServletRequest request);
 /**
* 根据用户名获取用户
* @param username
*/
 Admin getAdminByUserName(String username);

}
