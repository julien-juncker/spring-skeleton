package com.spring.skeleton.survey.infrastructure.enterprise_a.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PostgresConfiguration {

    @Value("${enterpriseA.datasource.url}")
    private String datasourceUrl;

    @Value("${enterpriseA.datasource.username}")
    private String datasourceUsername;

    @Value("${enterpriseA.datasource.password}")
    private String datasourcePassword;

    @Bean
    public DataSource getPostgresDatasource() {
        final var datasourceBuilder = DataSourceBuilder.create();
        datasourceBuilder.driverClassName("org.postgresql.Driver");
        datasourceBuilder.url(datasourceUrl);
        datasourceBuilder.username(datasourceUsername);
        datasourceBuilder.password(datasourcePassword);
        return datasourceBuilder.build();
    }
}
