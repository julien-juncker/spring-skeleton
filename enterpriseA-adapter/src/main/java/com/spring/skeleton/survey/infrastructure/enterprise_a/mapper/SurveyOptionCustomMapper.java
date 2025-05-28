package com.spring.skeleton.survey.infrastructure.enterprise_a.mapper;

import com.spring.skeleton.domain.survey.value_objects.OpinionScaleEnum;
import com.spring.skeleton.domain.survey.value_objects.SurveyOption;
import com.spring.skeleton.domain.survey.value_objects.Graduation;
import com.spring.skeleton.domain.survey.value_objects.OpinionScale;
import com.spring.skeleton.survey.infrastructure.enterprise_a.entities.SurveyOptionDAO;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.List;

@Mapper
public class SurveyOptionCustomMapper {

    @Named("toSurveyOptionDAO")
    public List<SurveyOptionDAO> toSurveyOptionDAO(SurveyOption surveyOption) {
        return switch (surveyOption) {
            case Graduation graduation ->
                graduation.rangeValues().stream()
                        .map(valueInRange -> setSurveyOption(OpinionScaleEnum.fromInteger(valueInRange)))
                        .toList();
            case OpinionScale(List<OpinionScaleEnum> opinionScales) ->
                    opinionScales.stream().map(SurveyOptionCustomMapper::setSurveyOption).toList();
            case null -> Collections.emptyList();
        };
    }

    @Named("fromSurveyOptionDAO")
    public SurveyOption fromSurveyOptionDAO(List<SurveyOptionDAO> surveyOptionsDAO) {
        // For now, just create opinion scale type
        final var opinionsScale = surveyOptionsDAO.stream().map(this::surveyOptionToOpinionScaleEnum).toList();
        return new OpinionScale(opinionsScale);
    }

    private OpinionScaleEnum surveyOptionToOpinionScaleEnum(SurveyOptionDAO surveyOption) {
        if (surveyOption == null) {
            return null;
        }
        return OpinionScaleEnum.valueOf(surveyOption.getOption());
    }

    private static SurveyOptionDAO setSurveyOption(final OpinionScaleEnum convertedOpinionScale) {
        final var surveyDao = new SurveyOptionDAO();
        surveyDao.setOption(convertedOpinionScale.name());
        return surveyDao;
    }
}
