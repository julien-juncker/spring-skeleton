package com.spring.skeleton.apps.configuration;

import com.spring.skeleton.Application;
import com.spring.skeleton.survey.infrastructure.enterprise_a.configuration.PostgresEnterpriseATestConfiguration;
import com.spring.skeleton.survey.infrastructure.enterprise_b.configuration.MongoDBEnterpriseBTestConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = {Application.class, PostgresEnterpriseATestConfiguration.class, MongoDBEnterpriseBTestConfiguration.class})
@TestPropertySource("classpath:application.yaml")
@Sql(scripts = {"/sql/truncate.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class ApplicationStub {

}
