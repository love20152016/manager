package com.subject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName: Application
 * @Description:
 * @Author: liaijun
 * @Date: 2021/4/23 17:05
 */
@SpringBootApplication
@MapperScan(value = "com.subject.admin.dao") //扫描mapper文件
@EnableTransactionManagement //开启事务
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
