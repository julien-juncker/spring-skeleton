package com.spring.skeleton.domain.survey;

import com.spring.skeleton.domain.survey.exception.InvalidOpinionScaleEnumConversionException;
import com.spring.skeleton.domain.survey.value_objects.OpinionScaleEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SurveyOptionTest {

    @Test
    void shouldCreateOpinionScaleEnumFromInteger() {
        // GIVEN
        final var firstInteger = 0;
        final var secondInteger = 1;
        final var thirdInteger = 2;
        final var fourthInteger = 3;
        final var fifthInteger = 4;

        // WHEN
        final var firstOpinionScaleEnum = OpinionScaleEnum.fromInteger(firstInteger);
        final var secondOpinionScaleEnum = OpinionScaleEnum.fromInteger(secondInteger);
        final var thirdOpinionScaleEnum = OpinionScaleEnum.fromInteger(thirdInteger);
        final var fourthOpinionScaleEnum = OpinionScaleEnum.fromInteger(fourthInteger);
        final var fifthOpinionScaleEnum = OpinionScaleEnum.fromInteger(fifthInteger);

        // THEN
        Assertions.assertEquals(OpinionScaleEnum.ABSOLUTELY_NO, firstOpinionScaleEnum);
        Assertions.assertEquals(OpinionScaleEnum.NO, secondOpinionScaleEnum);
        Assertions.assertEquals(OpinionScaleEnum.MAYBE, thirdOpinionScaleEnum);
        Assertions.assertEquals(OpinionScaleEnum.YES, fourthOpinionScaleEnum);
        Assertions.assertEquals(OpinionScaleEnum.ABSOLUTELY_YES, fifthOpinionScaleEnum);
    }

    @Test
    void shouldThrowErrorWhenOpinionScaleEnumIsInvalid() {
        // GIVEN
        final var outOfRange = 100;
        final var outOfRange2 = -1;
        // WHEN
        final var error = Assertions.assertThrows(InvalidOpinionScaleEnumConversionException.class, () -> OpinionScaleEnum.fromInteger(outOfRange));
        final var error2 = Assertions.assertThrows(InvalidOpinionScaleEnumConversionException.class, () -> OpinionScaleEnum.fromInteger(outOfRange2));
        // THEN
        Assertions.assertEquals("Invalid opinion scale conversion: 100. Valid values are 0 to 4", error.getMessage());
        Assertions.assertEquals("Invalid opinion scale conversion: -1. Valid values are 0 to 4", error2.getMessage());
    }
}
