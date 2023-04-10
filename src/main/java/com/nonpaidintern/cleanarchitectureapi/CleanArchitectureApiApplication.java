package com.nonpaidintern.cleanarchitectureapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.nonpaidintern.cleanarchitectureapi.*")
//@EnableJpaRepositories(basePackages = "com.group_one.application.common.interfaces.persistence")
public class CleanArchitectureApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CleanArchitectureApiApplication.class, args);
    }

}
