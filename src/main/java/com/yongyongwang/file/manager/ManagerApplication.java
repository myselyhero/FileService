package com.yongyongwang.file.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @apiNote yongyongwang
 *
 * @email 1947920597@qq.com
 *
 * @desc:
 *
 * @// TODO: 2021/4/16
 */
@SpringBootApplication
public class ManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
        System.err.println("文件服务器启动成功！！！");
    }
}
