package com.spring.skeleton.survey.infrastructure.enterprise_a.configuration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistrar;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;

@TestConfiguration
public class PostgresEnterpriseATestConfiguration {

    @Bean
    @ServiceConnection
    public PostgreSQLContainer postgreSQLContainer() {
        var username = "EnterpriseAUser";
        var password = "TestPassword";
        try (var postgreSQLContainer = new PostgreSQLContainer<>("postgres").withUsername(username).withPassword(password).waitingFor(Wait.forListeningPort())) {
            return postgreSQLContainer;
        }
    }

    @Bean
    DynamicPropertyRegistrar apiPostgresPropertiesRegistrar(final PostgreSQLContainer postgreSQLContainer) {

        return properties -> {
            properties.add("enterpriseA.datasource.url", postgreSQLContainer::getJdbcUrl);
            properties.add("enterpriseA.datasource.username", postgreSQLContainer::getUsername);
            properties.add("enterpriseA.datasource.password", postgreSQLContainer::getPassword);
        };
    }
}
