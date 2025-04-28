package com.spring.skeleton.mapper;

import com.spring.skeleton.domain.petstore.object.Pet;
import com.spring.skeleton.generated.models.PetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PetDTOMapper {
    PetDTOMapper INSTANCE = Mappers.getMapper(PetDTOMapper.class);

    List<PetDTO> toPetDtoList(List<Pet> petList);
}
