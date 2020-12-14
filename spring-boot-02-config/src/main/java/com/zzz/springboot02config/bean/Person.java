package com.zzz.springboot02config.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 孟享广
 * @date 2020-12-02 5:33 下午
 * @description
 *  将配置文件yml中的每一个属性值，映射到这个组件中
 *
 *  @ConfigurationProperties 告诉SpringBoot将本类中的所有属性和配置文件中的相关配置进行绑定
 *          prefix = "person"配置文件中哪个属性与类的属性一一对应
 *
 *   只有这个组件是容器中的组件，才能容器提供的功能 @ConfigurationProperties功能
 */
@Component
@PropertySource(value = {"classpath:person.properties"})//指定配置文件
@ConfigurationProperties(prefix = "person")//从全局配置文件中获取
//@Validated//表示bean需要校验
public class Person {

    //lastName必须是邮箱格式 配置文件才支持校验
//    @Email
//    @Value("${person.last-name}")
    private String lastName;
//    @Value("#{12 + 12}")
    private Integer age;
    private Date birth;

//    @Value("${person.maps}") 最大的区别 不能引入复杂封装
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}
