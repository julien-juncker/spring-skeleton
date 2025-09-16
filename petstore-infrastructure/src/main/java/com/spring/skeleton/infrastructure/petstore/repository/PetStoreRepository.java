package com.spring.skeleton.infrastructure.petstore.repository;

import com.spring.skeleton.infrastructure.petstore.entities.PetStoreDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PetStoreRepository extends CrudRepository<PetStoreDAO, UUID> {
    Optional<PetStoreDAO> findByName(String name);
}
