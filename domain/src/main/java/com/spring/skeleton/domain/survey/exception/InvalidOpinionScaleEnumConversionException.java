package com.spring.skeleton.domain.survey.exception;

import com.spring.skeleton.domain.survey.value_objects.OpinionScaleEnum;

public class InvalidOpinionScaleEnumConversionException extends IllegalArgumentException {
    public InvalidOpinionScaleEnumConversionException(Integer number) {
        super("Invalid opinion scale conversion: " + number + ". Valid values are 0 to " + (OpinionScaleEnum.values().length - 1));
    }
}
