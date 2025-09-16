package com.spring.skeleton.infrastructure.petstore.mapper;

import com.spring.skeleton.domain.petstore.entity.PetStore;
import com.spring.skeleton.infrastructure.petstore.entities.PetStoreDAO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PetStoreDAOMapper {
    PetStoreDAOMapper INSTANCE = Mappers.getMapper(PetStoreDAOMapper.class);

    PetStoreDAO toPetStoreDAO(PetStore petStore);

    PetStore fromPetStoreDAO(PetStoreDAO petStoreDAO);
}
