package com.spring.skeleton.controller.mapper;

import com.spring.skeleton.domain.petstore.entity.Pet;
import com.spring.skeleton.domain.petstore.value_object.PetType;
import com.spring.skeleton.generated.models.CatDTO;
import com.spring.skeleton.generated.models.DogDTO;
import com.spring.skeleton.generated.models.OneOfPetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {OwnerDTOMapper.class, BreedCustomMapper.class})
public interface PetDTOMapper {
    PetDTOMapper INSTANCE = Mappers.getMapper(PetDTOMapper.class);

    @Mapping(source = "pet.breed", target = "breed", qualifiedByName = "toCatBreedDTO")
    CatDTO toCatDTO(Pet pet);

    @Mapping(source = "pet.breed", target = "breed", qualifiedByName = "toDogBreedDTO")
    DogDTO toDogDTO(Pet pet);

    @Mapping(source = "catDTO.breed", target = "breed", qualifiedByName = "fromCatBreedDTO")
    @Mapping(source = "petType", target = "type")
    Pet fromCatDTO(CatDTO catDTO, PetType petType);

    @Mapping(source = "dogDTO.breed", target = "breed", qualifiedByName = "fromDogBreedDTO")
    @Mapping(source = "petType", target = "type")
    Pet fromDogDTO(DogDTO dogDTO, PetType petType);

    default OneOfPetDTO toDTO(Pet pet) {
        if (pet == null) {
            return null;
        }
        if (PetType.CAT.equals(pet.type())) {
            return toCatDTO(pet);
        } else if(PetType.DOG.equals(pet.type())) {
            return toDogDTO(pet);
        }
        return null;
    }

    default Pet fromDTO(OneOfPetDTO petDto) {
        switch (petDto) {
            case CatDTO catDto -> {
                return fromCatDTO(catDto, PetType.CAT);
            }
            case DogDTO dogDto -> {
                return fromDogDTO(dogDto, PetType.DOG);
            }
            default -> {
                return null;
            }
        }
    }
}
