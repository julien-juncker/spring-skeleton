package com.spring.skeleton.controller.mapper;

import com.spring.skeleton.domain.survey.value_objects.Graduation;
import com.spring.skeleton.domain.survey.value_objects.OpinionScale;
import com.spring.skeleton.domain.survey.value_objects.OpinionScaleEnum;
import com.spring.skeleton.domain.survey.value_objects.SurveyOption;
import com.spring.skeleton.generated.models.GraduationDTO;
import com.spring.skeleton.generated.models.OpinionScaleDTO;
import com.spring.skeleton.generated.models.SurveyDTOOptions;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public class SurveyOptionDTOMapper {

    @Named("toSurveyOptionDTO")
    public SurveyDTOOptions toSurveyOptionDTO(SurveyOption surveyOption) {
        if (surveyOption == null) {
            return null;
        }
        switch (surveyOption) {
            case Graduation(List<Integer> value) -> {
                GraduationDTO graduationDTO = new GraduationDTO();
                graduationDTO.setGraduation(value);
                return graduationDTO;
            }
            case OpinionScale(List<OpinionScaleEnum> opinionScales) -> {
                OpinionScaleDTO opinionScaleDTO = new OpinionScaleDTO();
                opinionScaleDTO.setOpinionScale(mapToOpinionScaleDto(opinionScales));
                return opinionScaleDTO;
            }
            default -> {
                return null;
            }
        }
    }

    @Named("fromSurveyOptionDTO")
    public SurveyOption fromSurveyOptionDTO(SurveyDTOOptions surveyOptionDTO) {
        if (surveyOptionDTO == null) {
            return null;
        }
        return switch (surveyOptionDTO) {
            case GraduationDTO graduationDTO -> new Graduation(graduationDTO.getGraduation());
            case OpinionScaleDTO opinionScaleDTO -> new OpinionScale(mapFromOpinionScaleDto(opinionScaleDTO.getOpinionScale()));
            default -> null;
        };
    }

    private List<OpinionScaleDTO.OpinionScaleEnum> mapToOpinionScaleDto(List<OpinionScaleEnum> opinionScales) {
        return opinionScales.stream().map(opinionScaleEnum ->
                        OpinionScaleDTO.OpinionScaleEnum.valueOf(opinionScaleEnum.name())).toList();
    }

    private List<OpinionScaleEnum> mapFromOpinionScaleDto(List<OpinionScaleDTO.OpinionScaleEnum> opinionScalesDTO) {
        return opinionScalesDTO.stream().map(opinionScaleDTO ->
                OpinionScaleEnum.valueOf(opinionScaleDTO.name())).toList();
    }
}
