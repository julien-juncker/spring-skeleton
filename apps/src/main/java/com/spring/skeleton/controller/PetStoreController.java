package com.spring.skeleton.controller;

import com.spring.skeleton.domain.petstore.PetStoreService;
import com.spring.skeleton.dto.PetDto;
import com.spring.skeleton.mapper.PetDTOMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PetStoreController {
    private static final PetDTOMapper PET_DTO_MAPPER = PetDTOMapper.INSTANCE;
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
        return ResponseEntity.ok().body(PET_DTO_MAPPER.toPetDtoList(pets));
    }
}
