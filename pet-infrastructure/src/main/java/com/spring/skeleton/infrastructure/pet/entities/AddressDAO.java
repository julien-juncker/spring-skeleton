package com.spring.skeleton.infrastructure.pet.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

import java.io.Serializable;

@Entity(name = "owner_address")
@IdClass(AddressId.class)
public class AddressDAO {

    @Id
    @Column(nullable = false)
    private Integer number;

    @Id
    @Column(nullable = false)
    private String street;

    @Column
    private String city;

    @Column
    private String state;

    @Id
    @Column(nullable = false)
    private String zip;

    public AddressDAO(final Integer number, final String street, final String city, final String state, final String zip) {
        this.number = number;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public AddressDAO() {

    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(final Integer number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(final String zip) {
        this.zip = zip;
    }
}

@Embeddable
class AddressId implements Serializable {
    private Integer number;
    private String street;
    private String zip;

    public AddressId(final Integer number, final String street, final String zip) {
        this.number = number;
        this.street = street;
        this.zip = zip;
    }

    public AddressId() {

    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(final Integer number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(final String zip) {
        this.zip = zip;
    }
}
