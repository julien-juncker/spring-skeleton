package com.spring.skeleton.infrastructure.pet.mapper;

import com.spring.skeleton.domain.petstore.entity.Owner;
import com.spring.skeleton.infrastructure.pet.entities.OwnerDAO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {AddressDAOMapper.class})
public interface OwnerDAOMapper {
    OwnerDAO toDAO(Owner owner);

    Owner fromDAO(OwnerDAO ownerDAO);
}
