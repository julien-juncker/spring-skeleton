package com.spring.skeleton.domain.petstore;

import com.spring.skeleton.domain.petstore.entity.Pet;
import com.spring.skeleton.domain.petstore.entity.PetStore;
import com.spring.skeleton.domain.petstore.port.PetPort;
import com.spring.skeleton.domain.petstore.port.PetStorePort;

import java.util.AbstractMap;

public class PetStoreService {
    final PetStorePort petStorePort;
    final PetPort petPort;

    public PetStoreService(final PetStorePort petStorePort, final PetPort petPort) {
        this.petStorePort = petStorePort;
        this.petPort = petPort;
    }

    public AbstractMap.SimpleEntry<Pet, PetStore> addPetToStore(final Pet pet, final PetStore petStore) {
        final var persistedPetStore = petStorePort.getPetStoreByName(petStore.name())
                .orElse(petStorePort.createStore(petStore));
        final var persistedPet = petPort.registerPet(pet);
        return new AbstractMap.SimpleEntry<>(persistedPet, persistedPetStore);
    }
}
