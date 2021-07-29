package com.yeb.server.exception;

import com.yeb.server.pojo.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

// 全局异常处理

/*
@ControllerAdvice ：表示这是一个控制器增强类，当控制器发生异常且符合类中定义的拦截异 常类，将会被拦截
@ExceptionHandler ：定义拦截的异常类*/
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(SQLException.class)
    public RespBean mySQLException(SQLException e) {
        if (e instanceof SQLIntegrityConstraintViolationException) {
            return RespBean.error("该数据有关数据，操作失败！");
        } else {
            return RespBean.error("数据库异常，操作失败！");
        }
    }
}
