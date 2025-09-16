package com.spring.skeleton.infrastructure.pet.mapper;

import com.spring.skeleton.domain.petstore.value_object.Breed;
import com.spring.skeleton.domain.petstore.value_object.CatBreed;
import com.spring.skeleton.domain.petstore.value_object.DogBreed;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.Arrays;

@Mapper
public class BreedCustomMapper {
    @Named("toBreedDao")
    public String toBreedDao(Breed breed) {
        if (breed == null) {
            return null;
        }
        return breed.toString();
    }

    @Named("fromBreedDao")
    public Breed fromBreedDao(String breed) {
        if (breed == null) {
            return null;
        }
        if (isDogBreedValue(breed)) {
            return DogBreed.valueOf(breed);
        } else if (isCatBreedValue(breed)) {
            return CatBreed.valueOf(breed);
        } else {
            return null;
        }
    }

    private boolean isDogBreedValue(final String breed) {
        return Arrays.stream(DogBreed.values()).anyMatch(dogBreed -> breed.equals(dogBreed.name()));
    }

    private boolean isCatBreedValue(final String breed) {
        return Arrays.stream(CatBreed.values()).anyMatch(catBreed -> breed.equals(catBreed.name()));
    }
}
