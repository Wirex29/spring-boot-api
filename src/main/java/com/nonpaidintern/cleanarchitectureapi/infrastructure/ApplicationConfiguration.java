package com.nonpaidintern.cleanarchitectureapi.infrastructure;

import io.jkratz.mediator.core.Mediator;
import io.jkratz.mediator.core.Registry;
import io.jkratz.mediator.spring.SpringMediator;
import io.jkratz.mediator.spring.SpringRegistry;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class ApplicationConfiguration implements WebMvcConfigurer {

    private final ApplicationContext context;

    @Autowired
    public ApplicationConfiguration(ApplicationContext context) {
        this.context = context;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Registry registry() {
        return new SpringRegistry(context);
    }

    @Bean
    public Mediator mediator(Registry registry) {
        return new SpringMediator(registry);
    }


    @Override
    public void addResourceHandlers(@NonNull ResourceHandlerRegistry registry) {
        exposeDirectory("img", registry);
    }

    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
        Path uploadDir = Paths.get(dirName);
        String uploadPath = uploadDir.toFile().getAbsolutePath();

        if (dirName.startsWith("../")) dirName = dirName.replace("../", "");

        registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/" + uploadPath + "/");
    }

}
