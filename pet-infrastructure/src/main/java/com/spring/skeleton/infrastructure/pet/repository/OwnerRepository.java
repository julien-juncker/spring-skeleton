package com.spring.skeleton.infrastructure.pet.repository;

import com.spring.skeleton.infrastructure.pet.entities.OwnerDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OwnerRepository extends CrudRepository<OwnerDAO, UUID> {
    Optional<OwnerDAO> findByFirstNameAndLastName(final String firstName, final String lastName);
}
