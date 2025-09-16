package com.spring.skeleton.apps.integration;

import com.intuit.karate.junit5.Karate;
import com.spring.skeleton.apps.configuration.ApplicationStub;

public class PetStoreTest extends ApplicationStub {

    @Karate.Test
    Karate testPetStore() {
        return Karate.run("classpath:scenarii/petstore/petstore.feature");
    }
}
