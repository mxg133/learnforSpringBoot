package com.zzz.springboot.service;

import com.zzz.springboot.bean.Department;
import com.zzz.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

/**
 * @author 孟享广
 * @date 2020-12-12 2:12 下午
 * @description
 */

@Service
public class DeptService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    RedisCacheManager redisCacheManager;

//    @Cacheable(cacheNames = "dept")
    public Department getDeptById(Integer id) {
        System.out.println("查询" + id + "号部门...");
        Department department = departmentMapper.getDeptById(id);
        Cache dept = redisCacheManager.getCache("dept");
        dept.put("dept:1", department);
        return department;
    }
}
