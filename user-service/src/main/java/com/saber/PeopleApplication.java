package com.saber;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.saber.mapper")
public class PeopleApplication {
    public static void main(String[] args) {
        SpringApplication.run(PeopleApplication.class,args);
    }
}
