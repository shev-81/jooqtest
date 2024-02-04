package com.example.jooqtest.configurations;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    @Bean
    @ConditionalOnMissingBean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:5433/postgres")
                .username("postgres")
                .password("postgres")
                .build();
    }
}
