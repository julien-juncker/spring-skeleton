package com.spring.skeleton.survey.infrastructure.enterprise_b.configuration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistrar;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.containers.wait.strategy.Wait;

@TestConfiguration
public class MongoDBEnterpriseBTestConfiguration {
    @Bean
    @ServiceConnection
    public MongoDBContainer mongoDBContainer() {
        try (var mongoDBContainer = new MongoDBContainer("mongo").waitingFor(Wait.forListeningPort())) {
            return mongoDBContainer;
        }
    }

    @Bean
    DynamicPropertyRegistrar apiMongoDBPropertiesRegistrar(final MongoDBContainer mongoDBContainer) {
        return properties -> {
            properties.add("enterpriseB.datasource.url", mongoDBContainer::getConnectionString);
        };
    }
}
