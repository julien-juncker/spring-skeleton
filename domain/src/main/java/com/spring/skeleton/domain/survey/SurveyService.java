package com.spring.skeleton.domain.survey;

import com.spring.skeleton.domain.survey.entities.Survey;
import com.spring.skeleton.domain.survey.port.SurveyPort;

import java.util.ArrayList;
import java.util.List;

public class SurveyService {

    private final List<SurveyPort> surveysPort;

    public SurveyService(final List<SurveyPort> surveysPort) {
        this.surveysPort = surveysPort;
    }

    public void save(final Survey surveyToCreate) {
        for (SurveyPort surveyPort : surveysPort) {
            surveyPort.saveSurvey(aggregateSurveyWithEnterpriseName(surveyPort.getEnterpriseName(), surveyToCreate));
        }
    }

    public List<Survey> findAll() {
        var finalSurveys = new ArrayList<Survey>();
        for (SurveyPort surveyPort : surveysPort) {
            final var surveys = surveyPort.getSurveys();
            final var surveysWithEnterpriseNames = aggregateSurveysWithEnterpriseName(surveyPort.getEnterpriseName(), surveys);
            finalSurveys.addAll(surveysWithEnterpriseNames);
        }
        return finalSurveys;
    }

    private List<Survey> aggregateSurveysWithEnterpriseName(final String enterpriseName, final List<Survey> surveys) {
        return surveys.stream().map(survey -> aggregateSurveyWithEnterpriseName(enterpriseName, survey)).toList();
    }

    private Survey aggregateSurveyWithEnterpriseName(final String enterpriseName, final Survey survey) {
        return new Survey.Builder()
                .withEnterpriseName(enterpriseName)
                .withName(survey.name())
                .withDescription(survey.description())
                .withStatus(survey.status())
                .withQuestion(survey.question())
                .withOptions(survey.options())
                .withVotes(survey.votes())
                .build();
    }
}
