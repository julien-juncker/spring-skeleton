package com.spring.skeleton.controller;

import com.spring.skeleton.controller.mapper.PetDTOMapper;
import com.spring.skeleton.controller.mapper.PetStoreDTOMapper;
import com.spring.skeleton.domain.petstore.PetStoreService;
import com.spring.skeleton.generated.api.PetStoreApi;
import com.spring.skeleton.generated.models.PostPetToStoreRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetStoreController implements PetStoreApi {
    private static final PetDTOMapper PET_DTO_MAPPER = PetDTOMapper.INSTANCE;
    private static final PetStoreDTOMapper PET_STORE_DTO_MAPPER = PetStoreDTOMapper.INSTANCE;
    private final PetStoreService petStoreService;

    public PetStoreController(final PetStoreService petStoreService) {
        this.petStoreService = petStoreService;
    }

    @Override
    public ResponseEntity<PostPetToStoreRequest> postPetToStore(final PostPetToStoreRequest postPetToStoreRequest) {
        final var pet = PET_DTO_MAPPER.fromDTO(postPetToStoreRequest.getPet());
        final var petStore = PET_STORE_DTO_MAPPER.fromDTO(postPetToStoreRequest.getPetStore());
        final var registeredPetOnStore = petStoreService.addPetToStore(pet, petStore);

        final var response = new PostPetToStoreRequest();
        response.setPet(PET_DTO_MAPPER.toDTO(registeredPetOnStore.getKey()));
        response.setPetStore(PET_STORE_DTO_MAPPER.toDTO(registeredPetOnStore.getValue()));

        return ResponseEntity.ok(response);
    }
}
