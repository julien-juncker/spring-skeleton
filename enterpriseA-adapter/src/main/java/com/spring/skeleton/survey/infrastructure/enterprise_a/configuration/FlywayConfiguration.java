package com.spring.skeleton.survey.infrastructure.enterprise_a.configuration;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfiguration {
    @Bean
    public FlywayMigrationStrategy cleanMigrateStrategy() {
        //            flyway.repair(); only for emergency
        return Flyway::migrate;
    }
}
