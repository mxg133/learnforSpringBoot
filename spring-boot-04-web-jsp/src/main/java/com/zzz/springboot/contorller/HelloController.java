package com.zzz.springboot.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author 孟享广
 * @date 2020-12-09 3:12 下午
 * @description
 */

@Controller
public class HelloController {
    @RequestMapping("/abc")
    public String hello(Map<String, Object> map) {
        map.put("msg", "你哈皮");
        return "succcess";
    }

}
