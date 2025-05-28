package com.spring.skeleton.survey.infrastructure.enterprise_a;

import com.spring.skeleton.domain.survey.entities.Survey;
import com.spring.skeleton.domain.survey.port.SurveyPort;
import com.spring.skeleton.survey.infrastructure.enterprise_a.mapper.SurveyDAOMapper;
import com.spring.skeleton.survey.infrastructure.enterprise_a.repository.EnterpriseASurveyRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EnterpriseASurveyAdapter implements SurveyPort {

    static final String ENTERPRISE_NAME = "Enterprise A";
    static final SurveyDAOMapper SURVEY_MAPPER = SurveyDAOMapper.INSTANCE;
    final EnterpriseASurveyRepository surveyRepository;

    public EnterpriseASurveyAdapter(final EnterpriseASurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    public String getEnterpriseName() {
        return ENTERPRISE_NAME;
    }

    @Override
    public void saveSurvey(final Survey surveyToCreate) {
        final var surveyDAOToCreate = SURVEY_MAPPER.toSurveyDAO(surveyToCreate);
//        final var createdOptions = surveyDAOToCreate.getOptions().stream().map(optionToCreate -> surveyRepository.save());
        final var savedSurveyDAO = surveyRepository.save(surveyDAOToCreate);
        SURVEY_MAPPER.fromSurveyDAO(savedSurveyDAO);
    }

    @Override
    public List<Survey> getSurveys() {
        final var surveysDAO = surveyRepository.findAll();
        final var surveys = new ArrayList<Survey>();
        final var surveyDAOIterator = surveysDAO.iterator();
        while (surveyDAOIterator.hasNext()) {
            final var surveyDAO = surveyDAOIterator.next();
            surveys.add(SURVEY_MAPPER.fromSurveyDAO(surveyDAO));
        }
        return surveys;
    }
}
