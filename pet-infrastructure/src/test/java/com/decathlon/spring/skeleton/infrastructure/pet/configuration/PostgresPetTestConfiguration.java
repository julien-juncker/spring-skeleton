package com.decathlon.spring.skeleton.infrastructure.pet.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;

import javax.sql.DataSource;

@TestConfiguration
public class PostgresPetTestConfiguration {

    @Bean
    public DataSource petDataSource(@Qualifier("petContainer") PostgreSQLContainer<?> container) {
        return DataSourceBuilder.create()
                .driverClassName(container.getDriverClassName())
                .url(container.getJdbcUrl())
                .username(container.getUsername())
                .password(container.getPassword())
                .build();
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public PostgreSQLContainer<?> petContainer() {
        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:16"))
                .withDatabaseName("pet_db")
                .withUsername("pet_user")
                .withPassword("pet_password")
                .waitingFor(Wait.forListeningPort());
    }
}
