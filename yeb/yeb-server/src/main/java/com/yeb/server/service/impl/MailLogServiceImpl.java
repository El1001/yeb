package com.yeb.server.service.impl;

import com.yeb.server.pojo.MailLog;
import com.yeb.server.mapper.MailLogMapper;
import com.yeb.server.service.IMailLogService;
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
public class MailLogServiceImpl extends ServiceImpl<MailLogMapper, MailLog> implements IMailLogService {

}
