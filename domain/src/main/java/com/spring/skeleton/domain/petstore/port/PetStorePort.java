package com.spring.skeleton.domain.petstore.port;

import com.spring.skeleton.domain.petstore.entity.PetStore;

import java.util.Optional;

public interface PetStorePort {
    PetStore createStore(PetStore petStore);

    Optional<PetStore> getPetStoreByName(String name);
}
