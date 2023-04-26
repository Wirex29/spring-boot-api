package com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class PersistenceConfiguration {

    @Bean
    public DataSource dataSourceConfig() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://containers-us-west-36.railway.app:6063/railway");
        dataSource.setUsername("postgres");
        dataSource.setPassword("oel9hKFcsdJPvgwqMEb8");

        return dataSource;
    }
}
