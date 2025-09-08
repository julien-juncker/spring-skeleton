package com.spring.skeleton.domain.petstore.value_object;

public sealed interface Breed permits CatBreed, DogBreed {
}
