package com.spring.skeleton.infrastructure.pet.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

@Entity(name = "pet")
public class PetDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID tag;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String breed;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id")
    private OwnerDAO owner;

    public PetDAO(final UUID tag, final String name, final String type, final String breed, final OwnerDAO owner) {
        this.tag = tag;
        this.name = name;
        this.type = type;
        this.breed = breed;
        this.owner = owner;
    }

    public PetDAO() {

    }

    public UUID getTag() {
        return tag;
    }

    public void setTag(final UUID tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(final String breed) {
        this.breed = breed;
    }

    public OwnerDAO getOwner() {
        return owner;
    }

    public void setOwner(final OwnerDAO owner) {
        this.owner = owner;
    }
}
