package com.spring.skeleton.survey.infrastructure.enterprise_b;

import com.spring.skeleton.domain.survey.entities.Survey;
import com.spring.skeleton.domain.survey.port.SurveyPort;
import com.spring.skeleton.survey.infrastructure.enterprise_b.mapper.SurveyDAOMapper;
import com.spring.skeleton.survey.infrastructure.enterprise_b.repository.EnterpriseBSurveyRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnterpriseBSurveyAdapter implements SurveyPort {

    static final SurveyDAOMapper SURVEY_DAO_MAPPER = SurveyDAOMapper.INSTANCE;
    static final String ENTERPRISE_NAME = "Enterprise B";
    final EnterpriseBSurveyRepository surveyRepository;

    public EnterpriseBSurveyAdapter(final EnterpriseBSurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    public String getEnterpriseName() {
        return ENTERPRISE_NAME;
    }

    @Override
    public void saveSurvey(final Survey surveyToCreate) {
        final var surveyDAOToCreate = SURVEY_DAO_MAPPER.toSurveyDAO(surveyToCreate);
        if (surveyDAOToCreate != null) {
            surveyRepository.save(surveyDAOToCreate);
        }
    }

    @Override
    public List<Survey> getSurveys() {
        final var surveysDAO = surveyRepository.findAll();
        return surveysDAO.stream().map(SURVEY_DAO_MAPPER::fromSurveyDAO).toList();
    }
}
