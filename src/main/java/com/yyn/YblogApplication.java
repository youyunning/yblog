package com.yyn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class YblogApplication {
    public static void main(String[] args) {
        // 解决elasticsearch启动保存问题
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(YblogApplication.class, args);
        System.out.println("http://localhost:8000");

    }

}
