package com.zzz.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 孟享广
 * @date 2020-12-13 3:19 下午
 * @description
 */

@Service
public class AsyncService {
    //告诉Spring这是一个异步方法
    @Async
    public void hello() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("处理数据中·····");
    }

}
