package com.spring.skeleton.infrastructure.pet.mapper;

import com.spring.skeleton.domain.petstore.entity.Pet;
import com.spring.skeleton.infrastructure.pet.entities.PetDAO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {OwnerDAOMapper.class, BreedCustomMapper.class})
public interface PetDAOMapper {
    PetDAOMapper INSTANCE = Mappers.getMapper(PetDAOMapper.class);

    @Mapping(source = "pet.breed", target = "breed", qualifiedByName = "toBreedDao")
    PetDAO toDAO(Pet pet);

    @Mapping(source = "petDao.breed", target = "breed", qualifiedByName = "fromBreedDao")
    Pet fromDAO(PetDAO petDao);
}
