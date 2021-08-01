package com.yeb.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yeb.server.pojo.Employee;
import com.yeb.server.pojo.RespBean;
import com.yeb.server.pojo.RespPageBean;

import java.time.LocalDate;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zel
 * @since 2021-07-26
 */
public interface IEmployeeService extends IService<Employee> {

    //   获取员工分页
    RespPageBean getEmployeeByPage(Integer currentPages, Integer size, Employee employee, LocalDate[] beginDateScope);

}
