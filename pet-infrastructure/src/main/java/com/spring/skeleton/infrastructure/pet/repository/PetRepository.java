package com.spring.skeleton.infrastructure.pet.repository;

import com.spring.skeleton.infrastructure.pet.entities.PetDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PetRepository extends CrudRepository<PetDAO, UUID> {
}
