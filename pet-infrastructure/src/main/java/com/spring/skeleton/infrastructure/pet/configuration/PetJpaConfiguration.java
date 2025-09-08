package com.spring.skeleton.infrastructure.pet.configuration;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.spring.skeleton.infrastructure.pet",
        entityManagerFactoryRef = "petEntityManagerFactory",
        transactionManagerRef = "petTransactionManager"
)
public class PetJpaConfiguration {
    @Primary
    @DependsOn("petDataSource")
    @Bean(name = "petEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean petEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("petDataSource") DataSource dataSource) {

        Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db_migration/pet")
                .load()
                .migrate();

        return builder
                .dataSource(dataSource)
                .packages("com.spring.skeleton.infrastructure.pet")
                .build();
    }

    @Bean(name = "petTransactionManager")
    public PlatformTransactionManager petTransactionManager(
            @Qualifier("petEntityManagerFactory") LocalContainerEntityManagerFactoryBean petEntityManagerFactory) throws EntityManagerFactoryNotFoundException {
        if (petEntityManagerFactory == null || petEntityManagerFactory.getObject() == null) {
            throw new EntityManagerFactoryNotFoundException("petEntityManagerFactory is null");
        }
        return new JpaTransactionManager(petEntityManagerFactory.getObject());
    }
}
