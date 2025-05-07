package com.spring.skeleton.controller;

import com.spring.skeleton.domain.petstore.PetStoreService;
import com.spring.skeleton.generated.api.PetstoreApi;
import com.spring.skeleton.generated.models.PetDTO;
import com.spring.skeleton.controller.mapper.PetDTOMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PetStoreController implements PetstoreApi {
    private static final PetDTOMapper PET_DTO_MAPPER = PetDTOMapper.INSTANCE;
    private final PetStoreService petStoreService;


    public PetStoreController(final PetStoreService petStoreService) {
        this.petStoreService = petStoreService;
    }

    @Override
    public ResponseEntity<List<PetDTO>> getPets() {
        final var pets = petStoreService.getPets();
        return ResponseEntity.ok().body(PET_DTO_MAPPER.toPetDtoList(pets));
    }
}
