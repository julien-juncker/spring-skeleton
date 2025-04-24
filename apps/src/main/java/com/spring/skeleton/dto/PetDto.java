package com.spring.skeleton.dto;

public class PetDto {
    private final String name;
    private final String type;
    private final int age;

    public PetDto(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }
}
