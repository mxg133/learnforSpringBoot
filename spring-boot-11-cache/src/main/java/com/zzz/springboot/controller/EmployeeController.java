package com.zzz.springboot.controller;

import com.zzz.springboot.bean.Employee;
import com.zzz.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author 孟享广
 * @date 2020-12-11 2:35 下午
 * @description
 */

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmploy(@PathVariable("id") Integer id) {
        Employee employee = employeeService.getEmp(id);
        return employee;

    }

    @GetMapping("/emp")
    public Employee update(Employee employee) {
        Employee employee1 = employeeService.updateEmp(employee);
        return employee1;
    }

    @GetMapping("/del/{id}")
    public String del(@PathVariable("id") Integer id) {
        System.out.println("删除");
        employeeService.deleteEmp(id);
        return "success";
    }

    @GetMapping("/emp/lastname/{lastName}")
    public Employee getEmpByLastName(@PathVariable("lastName") String lastName){
        return employeeService.getEmpByLastName(lastName);
    }
}