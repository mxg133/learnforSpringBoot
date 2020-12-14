package com.zzz.springboot.controller;

import com.zzz.springboot.bean.Department;
import com.zzz.springboot.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 孟享广
 * @date 2020-12-12 2:19 下午
 * @description
 */

@Controller
public class DeptController {

    @Autowired
    DeptService deptService;

    @ResponseBody
    @RequestMapping("/dept/{id}")
    public Department getDeptById(@PathVariable("id")Integer id) {
        Department department = deptService.getDeptById(id);
        return department;
    }
}
