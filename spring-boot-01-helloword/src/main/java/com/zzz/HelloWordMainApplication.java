package com.zzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 孟享广
 * @date 2020-12-02 3:02 下午
 * @description
 * 来标注一个主程序类 说明这是一个SpringBoot应用
 * Spring Boot应用标注在某个类上说明这个类是SpringBoot的主配置关,
 * SpringBoot就应该运行这个类的main方法来启动SpringBoot应用;
 */

@SpringBootApplication
public class HelloWordMainApplication {
    public static void main(String[] args) {
        //Spring应用启动起立
        SpringApplication.run(HelloWordMainApplication.class, args);
    }
}
