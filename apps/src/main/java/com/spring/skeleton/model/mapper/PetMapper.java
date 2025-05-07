package com.spring.skeleton.model.mapper;

import com.spring.skeleton.domain.petstore.object.Pet;
import com.spring.skeleton.model.entity.PetDAO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PetMapper {
    PetMapper INSTANCE = Mappers.getMapper(PetMapper.class);

    Pet fromPetDao(PetDAO pet);
}
