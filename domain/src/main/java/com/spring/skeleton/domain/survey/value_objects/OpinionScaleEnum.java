package com.spring.skeleton.domain.survey.value_objects;

import com.spring.skeleton.domain.survey.exception.InvalidOpinionScaleEnumConversionException;

public enum OpinionScaleEnum {
    ABSOLUTELY_NO(0),
    NO(1),
    MAYBE(2),
    YES(3),
    ABSOLUTELY_YES(4);

    private final int number;

    OpinionScaleEnum(int number) {
        this.number = number;
    }

    public static OpinionScaleEnum fromInteger(Integer number) {
        if (number == null) {
            throw new IllegalArgumentException("Number cannot be null.");
        }
        for (OpinionScaleEnum opinionScaleEnum : values()) {
            if (opinionScaleEnum.number == number) {
                return opinionScaleEnum;
            }
        }
        throw new InvalidOpinionScaleEnumConversionException(number);
    }
}
