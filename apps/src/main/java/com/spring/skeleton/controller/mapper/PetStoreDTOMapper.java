package com.spring.skeleton.controller.mapper;

import com.spring.skeleton.domain.petstore.entity.PetStore;
import com.spring.skeleton.generated.models.PetStoreDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PetStoreDTOMapper {
    PetStoreDTOMapper INSTANCE = Mappers.getMapper(PetStoreDTOMapper.class);

    PetStoreDTO toDTO(PetStore petStore);

    PetStore fromDTO(PetStoreDTO petStoreDTO);
}
