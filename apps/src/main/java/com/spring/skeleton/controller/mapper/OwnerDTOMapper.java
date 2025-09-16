package com.spring.skeleton.controller.mapper;

import com.spring.skeleton.domain.petstore.entity.Owner;
import com.spring.skeleton.generated.models.OwnerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {AddressDTOMapper.class})
public interface OwnerDTOMapper {
    OwnerDTOMapper INSTANCE = Mappers.getMapper(OwnerDTOMapper.class);

    OwnerDTO toDTO(Owner owner);

    Owner fromDTO(OwnerDTO ownerDTO);
}
