package com.zzz.ticket.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zzz.ticket.service.TicketService;
import org.springframework.stereotype.Component;

/**
 * @author 孟享广
 * @date 2020-12-14 10:03 上午
 * @description
 */

@Component
@Service//将服务发布出去
public class TicketServiceImpl implements TicketService {

    @Override
    public String getTicket() {
        return "我爱美国";
    }
}
