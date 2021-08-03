package com.yeb.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeb.server.mapper.EmployeeMapper;
import com.yeb.server.pojo.Employee;
import com.yeb.server.pojo.RespBean;
import com.yeb.server.pojo.RespPageBean;
import com.yeb.server.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zel
 * @since 2021-07-26
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public RespPageBean getEmployeeByPage(Integer currentPage, Integer size,Employee employee, LocalDate[] beginDateScope) {
        //开启分页
        Page<Employee> page = new Page<>(currentPage, size);
        IPage<Employee> employeePage = employeeMapper.getEmployeeByPage(page,
                employee, beginDateScope);
        RespPageBean respPageBean = new
                RespPageBean(employeePage.getTotal(), employeePage.getRecords());
        return respPageBean;
    }

    // 获得最大工号
    @Override
    public RespBean maxWorkID() {
        List<Map<String, Object>> maps = employeeMapper.selectMaps(new QueryWrapper<Employee>().select("max(workID)"));
        return RespBean.success(null, String.format("%08d",Integer.parseInt(maps.get(0).get("max(workID)").toString()) + 1));

    }

    @Override
    public RespBean addEmp(Employee employee) {
        LocalDate beginContract =employee.getBeginContract();
        LocalDate endContract = employee.getEndContract();
        // 计算相差多少天
        long days = beginContract.until(endContract, ChronoUnit.DAYS);
        // double 计算 多少年
        DecimalFormat decimalFormat = new DecimalFormat("##.00");
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(days/365.00)));
        if (employeeMapper.insert(employee) > 0) {
            return RespBean.success("添加成功 ！ ");
        }
        return RespBean.error("添加失败");
    }

    /**
     * 查询员工
     * @param id
     * @return
     */
    @Override
    public List<Employee> getEmployee(Integer id) {
        return employeeMapper.getEmployee(id);
    }


}
