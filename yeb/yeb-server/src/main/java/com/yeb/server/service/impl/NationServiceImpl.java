package com.yeb.server.service.impl;

import com.yeb.server.pojo.Nation;
import com.yeb.server.mapper.NationMapper;
import com.yeb.server.service.INationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zel
 * @since 2021-07-26
 */
@Service
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements INationService {

}
