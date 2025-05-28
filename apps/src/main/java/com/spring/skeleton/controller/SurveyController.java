package com.spring.skeleton.controller;

import com.spring.skeleton.controller.mapper.SurveyDTOMapper;
import com.spring.skeleton.domain.survey.SurveyService;
import com.spring.skeleton.generated.api.SurveyApi;
import com.spring.skeleton.generated.models.SurveyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SurveyController implements SurveyApi {
    static final SurveyDTOMapper SURVEY_DTO_MAPPER = SurveyDTOMapper.INSTANCE;
    private final SurveyService surveyService;

    public SurveyController(final SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @Override
    public ResponseEntity<List<SurveyDTO>> getSurvey() throws Exception {
        final var surveys = surveyService.findAll();
        final var surveysDTO = surveys.stream().map(SURVEY_DTO_MAPPER::toSurveyDTO).toList();
        return ResponseEntity.ok(surveysDTO);
    }

    @Override
    public ResponseEntity<SurveyDTO> postSurvey(final SurveyDTO surveyDTO) {
        surveyService.save(SURVEY_DTO_MAPPER.fromSurveyDTO(surveyDTO));
        return ResponseEntity.ok(surveyDTO);
    }
}
