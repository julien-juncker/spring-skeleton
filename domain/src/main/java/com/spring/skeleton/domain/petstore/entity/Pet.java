package com.spring.skeleton.domain.petstore.entity;

import com.spring.skeleton.domain.petstore.value_object.Breed;
import com.spring.skeleton.domain.petstore.value_object.PetType;
import com.spring.skeleton.domain.utils.StringUtils;

import java.util.UUID;

public record Pet(UUID tag, String name, Owner owner, PetType type, Breed breed) {
    public Pet {
        petInvariants(name);
    }

    private void petInvariants(String name) {
        validateName(name);
    }

    private void validateName(String name) {
        if (StringUtils.isEmptyOrNull(name)) {
            throw new IllegalArgumentException("Pet name cannot be null or empty");
        }
    }
}
