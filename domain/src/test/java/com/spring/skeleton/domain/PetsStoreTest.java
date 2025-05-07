package com.spring.skeleton.domain;

import com.spring.skeleton.domain.petstore.PetStoreService;
import com.spring.skeleton.domain.petstore.object.Pet;
import com.spring.skeleton.domain.petstore.port.PetstorePort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.when;

class PetsStoreTest {

    @Test
    void testGetPets() {
        // GIVEN
        final var expectedPets = List.of(
                new Pet("Helios", "Cat", 3),
                new Pet("Fluffy", "Dog", 4));

        final var mockedPetStorePort = Mockito.mock(PetstorePort.class);
        when(mockedPetStorePort.getAllPets()).thenReturn(expectedPets);

        // WHEN
        final var petStoreService = new PetStoreService(mockedPetStorePort);
        final List<Pet> pets = petStoreService.getPets();

        // THEN
        Assertions.assertEquals(expectedPets, pets);
    }
}
