package com.spring.skeleton.model.adapter;

import com.spring.skeleton.domain.petstore.object.Pet;
import com.spring.skeleton.domain.petstore.port.PetstorePort;
import com.spring.skeleton.model.mapper.PetMapper;
import com.spring.skeleton.model.repository.PetStoreRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PetstoreAdapter implements PetstorePort {

    final PetStoreRepository petStoreRepository;

    public PetstoreAdapter(final PetStoreRepository petStoreRepository) {
        this.petStoreRepository = petStoreRepository;
    }

    @Override
    public List<Pet> getAllPets() {
        return petStoreRepository.findAll().stream().map(
                PetMapper.INSTANCE::fromPetDao
        ).toList();
    }
}
