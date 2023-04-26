package com.nonpaidintern.cleanarchitectureapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.nonpaidintern.cleanarchitectureapi.*")
@EnableJpaRepositories(basePackages = "com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.repository")
public class CleanArchitectureApiApplication {

    public static void main(String[] args) {
        System.out.println(org.hibernate.Version.getVersionString());
        SpringApplication.run(CleanArchitectureApiApplication.class, args);
    }

}
