package com.spring.skeleton.infrastructure.pet.repository;

import com.spring.skeleton.infrastructure.pet.entities.AddressDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressRepository extends CrudRepository<AddressDAO, UUID> {
    Optional<AddressDAO> findByNumberAndStreetAndZip(final Integer number, final String street, final String zip);
}
