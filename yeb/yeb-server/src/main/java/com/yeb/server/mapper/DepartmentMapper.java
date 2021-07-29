package com.yeb.server.mapper;

import com.yeb.server.pojo.Department;
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
public interface DepartmentMapper extends BaseMapper<Department> {
//    获取所有部门
    List<Department> getAllDepartmentsByParentId(Integer parentId);
//      添加部门
    void addDep(Department dep);
//  删除部门
    void deleteDep(Department dep);
}
