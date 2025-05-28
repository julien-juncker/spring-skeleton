package com.spring.skeleton.domain.survey.value_objects;

import java.util.List;

public record OpinionScale(List<OpinionScaleEnum> opinionScales) implements SurveyOption { }

