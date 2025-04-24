package com.spring.skeleton.controller;

import com.spring.skeleton.domain.petstore.PetStoreService;
import com.spring.skeleton.dto.PetDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PetStoreController {
    private final PetStoreService petStoreService;

    public PetStoreController(final PetStoreService petStoreService) {
        this.petStoreService = petStoreService;
    }

    @GetMapping(
            value = "/api/v1/pets",
            produces = {
                    "application/json" }
    )
    public ResponseEntity<List<PetDto>> getPets() {
        final var pets = petStoreService.getPets();

        // need to use mapStruct after
        final var petsDTO = pets.stream().map(
                pet -> new PetDto(pet.name(), pet.type(), pet.age())).toList();

        return ResponseEntity.ok().body(petsDTO);
    }
}
