package com.spring.skeleton.controller.mapper;

import com.spring.skeleton.domain.survey.entities.Survey;
import com.spring.skeleton.generated.models.SurveyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {SurveyOptionDTOMapper.class})
public interface SurveyDTOMapper {

    SurveyDTOMapper INSTANCE = Mappers.getMapper(SurveyDTOMapper.class);

    @Mapping(source = "surveyDTO.options", target = "options", qualifiedByName = "fromSurveyOptionDTO")
    Survey fromSurveyDTO(SurveyDTO surveyDTO);

    @Mapping(source = "survey.options", target = "options", qualifiedByName = "toSurveyOptionDTO")
    SurveyDTO toSurveyDTO(Survey survey);
}
