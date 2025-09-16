package com.spring.skeleton.domain.petstore.value_object;

import com.spring.skeleton.domain.utils.StringUtils;

public record Address(Integer number, String street, String city, String state, String zip) {

    public static final int ADDRESS_NUMBER_MIN = 1;
    public static final int ADDRESS_NUMBER_MAX = 1000;

    public Address {
        addressInvariants(number, street, city, zip);
    }

    private void addressInvariants(final Integer number,
                                  final String street,
                                  final String city,
                                  final String zip) {
        validateNumber(number);
        validateStreet(street);
        validateCity(city);
        validateZip(zip);
    }

    private void validateNumber(final Integer number) {
        if (number == null) {
            throw new IllegalArgumentException("Address number cannot be null");
        }
        if (number < ADDRESS_NUMBER_MIN || number > ADDRESS_NUMBER_MAX) {
            throw new IllegalArgumentException("Address number cannot less than " + ADDRESS_NUMBER_MIN + " or more than " + ADDRESS_NUMBER_MAX);
        }
    }

    private void validateStreet(final String street) {
        if (StringUtils.isEmptyOrNull(street)) {
            throw new IllegalArgumentException("Street cannot be null");
        }
    }

    private void validateCity(final String city) {
        if (StringUtils.isEmptyOrNull(city)) {
            throw new IllegalArgumentException("City cannot be null");
        }
    }

    private void validateZip(final String zip) {
        if (StringUtils.isEmptyOrNull(zip)) {
            throw new IllegalArgumentException("Zip cannot be null");
        }
    }
}
