package com.spring.skeleton.domain.petstore.entity;

import com.spring.skeleton.domain.petstore.value_object.Address;
import com.spring.skeleton.domain.utils.StringUtils;

import java.util.UUID;

public record Owner(UUID id, String firstName, String lastName, Address address) {
    public Owner {
        ownerInvariants(firstName, lastName);
    }

    private void ownerInvariants(final String firstName,
                                 final String lastName) {
        validateFirstName(firstName);
        validateLastName(lastName);
    }

    private void validateFirstName(final String firstName) {
        if (StringUtils.isEmptyOrNull(firstName)) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
    }

    private void validateLastName(final String lastName) {
        if (StringUtils.isEmptyOrNull(lastName)) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
    }
}
