package com.zzz.springboot.repository;

import com.zzz.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//继承JpaRepository来完成对数据库的操作
//User说明操作哪个实体类？   ,Integer主键的类型
public interface UserRepository extends JpaRepository<User,Integer> {
}
