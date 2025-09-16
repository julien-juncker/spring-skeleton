package com.spring.skeleton.controller.mapper;

import com.spring.skeleton.domain.petstore.value_object.Breed;
import com.spring.skeleton.domain.petstore.value_object.CatBreed;
import com.spring.skeleton.domain.petstore.value_object.DogBreed;
import com.spring.skeleton.generated.models.CatDTO;
import com.spring.skeleton.generated.models.DogDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper
public class BreedCustomMapper {
    @Named("toCatBreedDTO")
    public CatDTO.BreedEnum toCatBreedDTO(Breed catBreed) {
        return CatDTO.BreedEnum.valueOf(catBreed.toString());
    }

    @Named("toDogBreedDTO")
    public DogDTO.BreedEnum toDogBreedDTO(Breed dogBreed) {
        return DogDTO.BreedEnum.valueOf(dogBreed.toString());
    }

    @Named("fromCatBreedDTO")
    public Breed fromCatBreedDTO(CatDTO.BreedEnum catBreedDTO) {
        return CatBreed.valueOf(catBreedDTO.toString());
    }

    @Named("fromDogBreedDTO")
    public Breed fromDogBreedDTO(DogDTO.BreedEnum dogBreedDTO) {
        return DogBreed.valueOf(dogBreedDTO.toString());
    }
}
