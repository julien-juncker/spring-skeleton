package com.spring.skeleton.domain.petstore;

import com.spring.skeleton.domain.petstore.object.Pet;
import com.spring.skeleton.domain.petstore.port.PetstorePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetStoreService {
    private final PetstorePort petstorePort;

    public PetStoreService(final PetstorePort petstorePort) {
        this.petstorePort = petstorePort;
    }

    public List<Pet> getPets() {
        return petstorePort.getAllPets();
    }
}
