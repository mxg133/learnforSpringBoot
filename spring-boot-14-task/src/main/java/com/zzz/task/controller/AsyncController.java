package com.zzz.task.controller;

import com.zzz.task.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 孟享广
 * @date 2020-12-13 3:21 下午
 * @description
 */

@RestController
public class AsyncController {
    @Autowired
    AsyncService asyncService;

    @GetMapping("hello")
    public String hello() throws InterruptedException {
        asyncService.hello();
        return "success";
    }

}
