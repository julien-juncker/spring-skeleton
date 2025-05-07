package com.spring.skeleton.domain.petstore.port;

import com.spring.skeleton.domain.petstore.object.Pet;

import java.util.List;

public interface PetstorePort {
    List<Pet> getAllPets();
}
