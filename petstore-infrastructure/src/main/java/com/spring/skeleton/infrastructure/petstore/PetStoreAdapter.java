package com.spring.skeleton.infrastructure.petstore;

import com.spring.skeleton.domain.petstore.entity.PetStore;
import com.spring.skeleton.domain.petstore.port.PetStorePort;
import com.spring.skeleton.infrastructure.petstore.mapper.PetStoreDAOMapper;
import com.spring.skeleton.infrastructure.petstore.repository.PetStoreRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PetStoreAdapter implements PetStorePort {

    private static final PetStoreDAOMapper PET_STORE_DAO_MAPPER = PetStoreDAOMapper.INSTANCE;
    private final PetStoreRepository petStoreRepository;

    public PetStoreAdapter(final PetStoreRepository petStoreRepository) {
        this.petStoreRepository = petStoreRepository;
    }

    @Override
    public PetStore createStore(final PetStore petStore) {
        final var petStoreDAO = PET_STORE_DAO_MAPPER.toPetStoreDAO(petStore);
        final var createdPetStore = petStoreRepository.save(petStoreDAO);
        return PET_STORE_DAO_MAPPER.fromPetStoreDAO(createdPetStore);
    }

    @Override
    public Optional<PetStore> getPetStoreByName(final String name) {
        return petStoreRepository
                .findByName(name)
                .map(PET_STORE_DAO_MAPPER::fromPetStoreDAO);
    }
}
