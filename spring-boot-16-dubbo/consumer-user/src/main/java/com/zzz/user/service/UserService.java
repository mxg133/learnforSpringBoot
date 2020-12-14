package com.zzz.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zzz.ticket.service.TicketService;
import org.springframework.stereotype.Service;

/**
 * @author 孟享广
 * @date 2020-12-14 10:05 上午
 * @description
 */
@Service
public class UserService {
    @Reference
    TicketService ticketService;

    public void hello() {
        String ticket = ticketService.getTicket();
        System.out.println(ticket);
    }
}
