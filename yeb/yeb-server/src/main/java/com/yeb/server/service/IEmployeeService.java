package com.yeb.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yeb.server.pojo.Employee;
import com.yeb.server.pojo.RespBean;
import com.yeb.server.pojo.RespPageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zel
 * @since 2021-07-26
 */
public interface IEmployeeService extends IService<Employee> {

    //   获取员工分页
    RespPageBean getEmployeeByPage(Integer currentPages, Integer size, Employee employee, LocalDate[] beginDateScope);

    // 获取最大工号
    RespBean maxWorkID();

    //  添加员工
    RespBean addEmp(Employee employee);

    /**
     * 查询员工
     * @param id
     * @return
     */
    List<Employee> getEmployee(Integer id);

}
