package com.yeb.server.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.yeb.server.pojo.Position;
import com.yeb.server.pojo.RespBean;
import com.yeb.server.service.IPositionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zel
 * @since 2021-07-26
 */
@RestController
@RequestMapping("/system/basic/position")
public class PositionController {
    @Autowired
    private IPositionService positionService;

    @ApiOperation(value = "获取职位信息")
    @GetMapping("/")
    public List<Position> getAllPositions() {
        // extends IService 中 iservice 的方法 查找所有结果
        return positionService.list();
    }

    @ApiOperation(value = "添加职位")
    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position) {
        // 方法从默认时区中的系统时钟获取当前日期时间。    
        position.setCreateDate(LocalDateTime.now());
        // 插入一条记录（选择字段，策略插入）
        // Params:
        //entity – 实体对象
        if (positionService.save(position)) {
            return RespBean.success("添加成功");
        } else {
            return RespBean.error("添加失败");
        }
    }

    @ApiOperation(value = "更新职位信息")
    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position) {
        position.setCreateDate(LocalDateTime.now());
        if (positionService.updateById(position)) {
            return RespBean.success("更新成功");
        } else {
            return RespBean.error("更新失败");
        }
    }

    @ApiOperation(value = "删除职位信息")
    @DeleteMapping("/{id}")
    public RespBean deletePosition(@PathVariable Integer id) {
        if (positionService.removeById(id)) {
            return RespBean.success("删除成功");
        } else {
            return RespBean.error("删除失败");
        }
    }

    @ApiOperation(value = "批量删除职位")
    @DeleteMapping("/")
    public RespBean deletePositions(Integer[] ids) {
        if (positionService.removeByIds(Arrays.asList(ids))) {
            return RespBean.success("删除成功");
        } else {
            return RespBean.error("删除失败");
        }
    }
}
