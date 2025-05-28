package com.spring.skeleton.survey.infrastructure.enterprise_b.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.UuidRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoDBConfiguration {
    @Value("${enterpriseB.datasource.url}")
    private String mongoUri;

    @Bean
    public MongoClient getMongoDBClient() {
        final var mongoSettings = MongoClientSettings
                .builder()
                .uuidRepresentation(UuidRepresentation.STANDARD)
                .applyConnectionString(new ConnectionString(mongoUri))
                .build();
        return MongoClients.create(mongoSettings);
    }

    @Bean
    public UuidIdentifiedEntityEventListener uuidIdentifiedEntityEventListener() {
        return new UuidIdentifiedEntityEventListener();
    }
}
