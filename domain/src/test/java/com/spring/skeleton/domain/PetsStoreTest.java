package com.spring.skeleton.domain;

import com.spring.skeleton.domain.petstore.PetStoreService;
import com.spring.skeleton.domain.petstore.object.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PetsStoreTest {

    @Test
    void testGetPets() {
        // GIVEN
        final var expectedPets = List.of(
                new Pet("Helios", "Cat", 3),
                new Pet("Fluffy", "Dog", 4));

        // WHEN
        final var petStoreService = new PetStoreService();
        final List<Pet> pets = petStoreService.getPets();

        // THEN
        Assertions.assertEquals(expectedPets, pets);
    }
}
