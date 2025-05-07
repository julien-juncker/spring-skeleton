package com.spring.skeleton.model.repository;

import com.spring.skeleton.model.entity.PetDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PetStoreRepository extends CrudRepository<PetDAO, UUID> {
    List<PetDAO> findAll();
}
