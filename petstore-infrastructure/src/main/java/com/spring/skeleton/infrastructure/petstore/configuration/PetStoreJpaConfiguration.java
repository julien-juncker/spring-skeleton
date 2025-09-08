package com.spring.skeleton.infrastructure.petstore.configuration;


import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.spring.skeleton.infrastructure.petstore",
        entityManagerFactoryRef = "petStoreEntityManagerFactory",
        transactionManagerRef = "petStoreTransactionManager"
)
public class PetStoreJpaConfiguration {

    @Bean(name = "petStoreEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean petStoreEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("petStoreDataSource") DataSource dataSource) {

        Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db_migration/petStore")
                .load()
                .migrate();

        return builder
                .dataSource(dataSource)
                .packages("com.spring.skeleton.infrastructure.petstore")
                .build();
    }

    @Bean(name = "petStoreTransactionManager")
    public PlatformTransactionManager petStoreTransactionManager(
            @Qualifier("petStoreEntityManagerFactory") LocalContainerEntityManagerFactoryBean petStoreEntityManagerFactory) throws EntityManagerFactoryNotFoundException {
        if (petStoreEntityManagerFactory == null || petStoreEntityManagerFactory.getObject() == null) {
            throw new EntityManagerFactoryNotFoundException("petStoreEntityManagerFactory is null");
        }
        return new JpaTransactionManager(petStoreEntityManagerFactory.getObject());
    }
}
