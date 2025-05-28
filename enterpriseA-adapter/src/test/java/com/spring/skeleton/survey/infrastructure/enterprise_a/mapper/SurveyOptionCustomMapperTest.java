package com.spring.skeleton.survey.infrastructure.enterprise_a.mapper;

import com.spring.skeleton.domain.survey.value_objects.Graduation;
import com.spring.skeleton.survey.infrastructure.enterprise_a.entities.SurveyOptionDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

class SurveyOptionCustomMapperTest {

    @Test
    void shouldMapSurveyOptionIntegerFromGraduation() {
        // GIVEN
        final var surveyOption = new Graduation(List.of(0,1,2,3,4));
        final var mapper = new SurveyOptionCustomMapper();
        final var expectedSurveyOptionDAO = createSurveyOptionDAOList();
        // WHEN
        final var mappedOption = mapper.toSurveyOptionDAO(surveyOption);
        // THEN
        IntStream.range(0, mappedOption.size()).forEach(i -> {
            Assertions.assertEquals(expectedSurveyOptionDAO.get(i).getOption(), mappedOption.get(i).getOption());
        });
    }

    @Test
    void shouldThrowErrorWhenRangeIsOutOfBounds() {
        // GIVEN
        final var mapper = new SurveyOptionCustomMapper();
        final var surveyOption = new Graduation(List.of(0,1,2,3,4,5));
        final var surveyOption2 = new Graduation(List.of(-1));
        // WHEN
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> mapper.toSurveyOptionDAO(surveyOption));
        final var exception2 = Assertions.assertThrows(IllegalArgumentException.class, () -> mapper.toSurveyOptionDAO(surveyOption2));
        // THEN
        Assertions.assertEquals("Invalid opinion scale conversion: 5. Valid values are 0 to 4", exception.getMessage());
        Assertions.assertEquals("Invalid opinion scale conversion: -1. Valid values are 0 to 4", exception2.getMessage());
    }

    private List<SurveyOptionDAO> createSurveyOptionDAOList() {
        final var surveyOptionDAO1 = new SurveyOptionDAO();
        surveyOptionDAO1.setOption("ABSOLUTELY_NO");
        final var surveyOptionDAO2 = new SurveyOptionDAO();
        surveyOptionDAO2.setOption("NO");
        final var surveyOptionDAO3 = new SurveyOptionDAO();
        surveyOptionDAO3.setOption("MAYBE");
        final var surveyOptionDAO4 = new SurveyOptionDAO();
        surveyOptionDAO4.setOption("YES");
        final var surveyOptionDAO5 = new SurveyOptionDAO();
        surveyOptionDAO5.setOption("ABSOLUTELY_YES");
        return List.of(surveyOptionDAO1, surveyOptionDAO2, surveyOptionDAO3, surveyOptionDAO4, surveyOptionDAO5);
    }
}
