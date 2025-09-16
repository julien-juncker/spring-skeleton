package com.spring.skeleton.controller.mapper;

import com.spring.skeleton.domain.petstore.value_object.Address;
import com.spring.skeleton.generated.models.AddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressDTOMapper {
    AddressDTOMapper INSTANCE = Mappers.getMapper(AddressDTOMapper.class);

    AddressDTO toDTO(Address address);

    Address fromDTO(AddressDTO addressDTO);
}
