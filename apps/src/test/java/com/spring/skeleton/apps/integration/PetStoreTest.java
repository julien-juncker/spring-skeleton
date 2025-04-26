package com.spring.skeleton.apps.integration;

import com.intuit.karate.junit5.Karate;
import com.spring.skeleton.apps.ApplicationStub;

class PetStoreTest extends ApplicationStub {

    @Karate.Test
    Karate testGetPets() {
        return Karate.run("classpath:scenarii/petstore/petstore.feature");
    }
}
