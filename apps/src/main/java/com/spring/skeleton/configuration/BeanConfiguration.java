package com.spring.skeleton.configuration;

import com.spring.skeleton.domain.petstore.PetStoreService;
import com.spring.skeleton.domain.petstore.port.PetPort;
import com.spring.skeleton.domain.petstore.port.PetStorePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public PetStoreService petStoreService(final PetStorePort petStorePort, final PetPort petPort) {
        return new PetStoreService(petStorePort, petPort);
    }
}
