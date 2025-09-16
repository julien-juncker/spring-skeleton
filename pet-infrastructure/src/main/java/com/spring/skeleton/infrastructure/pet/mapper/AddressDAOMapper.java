package com.spring.skeleton.infrastructure.pet.mapper;

import com.spring.skeleton.domain.petstore.value_object.Address;
import com.spring.skeleton.infrastructure.pet.entities.AddressDAO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressDAOMapper {
    AddressDAO toDAO(Address address);

    Address fromDAO(AddressDAO addressDAO);
}
