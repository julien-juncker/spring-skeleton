package com.spring.skeleton.infrastructure.pet.configuration;

public class EntityManagerFactoryNotFoundException extends Exception {
    public EntityManagerFactoryNotFoundException(String message) {
        super(message);
    }
}
