package com.spring.skeleton.domain.survey.port;

import com.spring.skeleton.domain.survey.entities.Survey;

import java.util.List;

public interface SurveyPort {
    void saveSurvey(Survey surveyToCreate);

    List<Survey> getSurveys();

    String getEnterpriseName();
}
