package com.yeb.server.service;

import com.yeb.server.pojo.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yeb.server.pojo.RespBean;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zel
 * @since 2021-07-26
 */
public interface IDepartmentService extends IService<Department> {
    //    获取所有部门
    List<Department> getAllDepartments();

    //      添加部门
    RespBean addDep(Department dep);

    //  删除部门
    RespBean deleteDep(Integer id);
}
