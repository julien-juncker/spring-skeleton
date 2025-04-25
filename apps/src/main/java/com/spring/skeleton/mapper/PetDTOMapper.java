package com.spring.skeleton.mapper;

import com.spring.skeleton.domain.petstore.object.Pet;
import com.spring.skeleton.dto.PetDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PetDTOMapper {
    PetDTOMapper INSTANCE = Mappers.getMapper(PetDTOMapper.class);

    List<PetDto> toPetDtoList(List<Pet> petList);
}
