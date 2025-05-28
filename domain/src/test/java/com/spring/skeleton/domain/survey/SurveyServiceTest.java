package com.spring.skeleton.domain.survey;

import com.spring.skeleton.domain.survey.entities.Survey;
import com.spring.skeleton.domain.survey.port.SurveyPort;
import com.spring.skeleton.domain.survey.value_objects.Graduation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

class SurveyServiceTest {

    @Test
    void shouldCreateSurvey() {
        // GIVEN
        final var surveyToSave = new Survey(
                null,
                "surveyA",
                "some survey description",
                "validated",
                "Is this a survey ?",
                new Graduation(List.of(0,1,2,3,4)),
                0
        );
        final var expectedSurvey = new Survey(
                "some_enterprise",
                "surveyA",
                "some survey description",
                "validated",
                "Is this a survey ?",
                new Graduation(List.of(0,1,2,3,4)),
                0
        );
        final var mockedPort = Mockito.mock(SurveyPort.class);
        Mockito.when(mockedPort.getEnterpriseName()).thenReturn("some_enterprise");
        Mockito.doNothing().when(mockedPort).saveSurvey(expectedSurvey);
        final var surveyService = new SurveyService(List.of(mockedPort));
        // WHEN
        Assertions.assertDoesNotThrow(() -> surveyService.save(surveyToSave));
        // THEN
        Mockito.verify(mockedPort).saveSurvey(expectedSurvey);
    }

    @Test
    void shouldFindSurveys() {
        // GIVEN
        final var survey1 = new Survey(
                null,
                "survey1",
                "some survey description",
                "validated",
                "Is this a survey ?",
                new Graduation(List.of(0,1,2,3,4)),
                0
        );
        final var survey2 = new Survey(
                null,
                "survey2",
                "some survey description",
                "validated",
                "Is this a survey ?",
                new Graduation(List.of(0,1,2,3,4)),
                0
        );
        final var expectedSurvey1 = new Survey(
                "some_enterprise",
                "survey1",
                "some survey description",
                "validated",
                "Is this a survey ?",
                new Graduation(List.of(0,1,2,3,4)),
                0
        );
        final var expectedSurvey2 = new Survey(
                "some_enterprise",
                "survey2",
                "some survey description",
                "validated",
                "Is this a survey ?",
                new Graduation(List.of(0,1,2,3,4)),
                0
        );
        final var mockedPort = Mockito.mock(SurveyPort.class);
        Mockito.when(mockedPort.getEnterpriseName()).thenReturn("some_enterprise");
        Mockito.when(mockedPort.getSurveys()).thenReturn(List.of(survey1, survey2));
        final var surveyService = new SurveyService(List.of(mockedPort));
        // WHEN
        final var expectedSurveys = surveyService.findAll();
        // THEN
        Assertions.assertEquals(expectedSurvey1, expectedSurveys.getFirst());
        Assertions.assertEquals(expectedSurvey2, expectedSurveys.getLast());
    }
}
