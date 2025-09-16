package com.spring.skeleton.domain.petstore.port;

import com.spring.skeleton.domain.petstore.entity.Pet;

public interface PetPort {
    Pet registerPet(Pet pet);
}
