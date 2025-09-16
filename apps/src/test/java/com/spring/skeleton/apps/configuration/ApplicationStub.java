package com.spring.skeleton.apps.configuration;

import com.decathlon.skeleton.infrastructure.petstore.configuration.PostgresPetStoreTestConfiguration;
import com.decathlon.spring.skeleton.infrastructure.pet.configuration.PostgresPetTestConfiguration;
import com.spring.skeleton.Application;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = {
        Application.class,
        PostgresPetStoreTestConfiguration.class,
        PostgresPetTestConfiguration.class
})
@TestPropertySource("classpath:application.yaml")
@Sql(scripts = {"/sql/truncate.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class ApplicationStub {

}
