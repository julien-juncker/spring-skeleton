package com.spring.skeleton.infrastructure.petstore.configuration;

public class EntityManagerFactoryNotFoundException extends Exception {
    public EntityManagerFactoryNotFoundException(String message) {
        super(message);
    }
}
