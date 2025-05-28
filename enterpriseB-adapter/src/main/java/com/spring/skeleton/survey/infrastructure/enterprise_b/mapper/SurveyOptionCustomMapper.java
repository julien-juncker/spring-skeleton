package com.spring.skeleton.survey.infrastructure.enterprise_b.mapper;

import com.spring.skeleton.domain.survey.value_objects.Graduation;
import com.spring.skeleton.domain.survey.value_objects.SurveyOption;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.List;

@Mapper
public class SurveyOptionCustomMapper {

    @Named("toSurveyOptionDAO")
    public List<Integer> toSurveyOptionDAO(SurveyOption surveyOption) {
        if (surveyOption instanceof Graduation(List<Integer> rangeValues)) {
            return rangeValues;
        } else {
            return Collections.emptyList();
        }
    }

    @Named("fromSurveyOptionDAO")
    public SurveyOption fromSurveyOptionDAO(List<Integer> surveyOptionsDAO) {
        return new Graduation(surveyOptionsDAO);
    }
}
