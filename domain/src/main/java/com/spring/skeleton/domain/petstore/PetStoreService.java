package com.spring.skeleton.domain.petstore;

import com.spring.skeleton.domain.petstore.object.Pet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetStoreService {
    public List<Pet> getPets() {
        return List.of(
                new Pet("Helios", "Cat", 3),
                new Pet("Fluffy", "Dog", 4)
        );
    }
}
