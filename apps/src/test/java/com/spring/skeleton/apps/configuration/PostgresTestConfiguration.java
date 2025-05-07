package com.spring.skeleton.apps.configuration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistrar;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;

@TestConfiguration
public class PostgresTestConfiguration {
    @Bean
    @ServiceConnection
    public PostgreSQLContainer postgreSQLContainer() {
        var username = "TestUser";
        var password = "TestPassword";
        try (var postgreSQLContainer = new PostgreSQLContainer<>("postgres").withUsername(username).withPassword(password).waitingFor(Wait.forListeningPort())) {
            return postgreSQLContainer;
        }
    }

    @Bean
    DynamicPropertyRegistrar apiPropertiesRegistrar(final PostgreSQLContainer postgreSQLContainer) {

        return properties -> {
            properties.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
            properties.add("spring.datasource.username", postgreSQLContainer::getUsername);
            properties.add("spring.datasource.password", postgreSQLContainer::getPassword);
        };
    }
}
