package com.decathlon.skeleton.infrastructure.petstore.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;

import javax.sql.DataSource;

@TestConfiguration
public class PostgresPetStoreTestConfiguration {

    @Bean(initMethod = "start", destroyMethod = "stop")
    @Primary
    public PostgreSQLContainer<?> petStoreContainer() {
        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:16"))
                .withDatabaseName("petstore_db")
                .withUsername("petstore_user")
                .withPassword("petstore_password")
                .waitingFor(Wait.forListeningPort());
    }

    @Bean
    @Primary
    public DataSource petStoreDataSource(PostgreSQLContainer<?> petStoreContainer) {
        return DataSourceBuilder.create()
                .url(petStoreContainer.getJdbcUrl())
                .username(petStoreContainer.getUsername())
                .password(petStoreContainer.getPassword())
                .build();
    }
}
