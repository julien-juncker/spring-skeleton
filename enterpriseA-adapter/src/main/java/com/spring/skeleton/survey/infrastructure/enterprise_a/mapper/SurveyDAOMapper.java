package com.spring.skeleton.survey.infrastructure.enterprise_a.mapper;

import com.spring.skeleton.domain.survey.entities.Survey;
import com.spring.skeleton.survey.infrastructure.enterprise_a.entities.SurveyDAO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {SurveyOptionCustomMapper.class})
public interface SurveyDAOMapper {
    SurveyDAOMapper INSTANCE = Mappers.getMapper(SurveyDAOMapper.class);

    @Mapping(source = "survey.options", target = "options", qualifiedByName = "toSurveyOptionDAO")
    SurveyDAO toSurveyDAO(Survey survey);

    @Mapping(source = "surveyDAO.options", target = "options", qualifiedByName = "fromSurveyOptionDAO")
    Survey fromSurveyDAO(SurveyDAO surveyDAO);
}

