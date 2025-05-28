package com.spring.skeleton.domain.survey.value_objects;

import java.util.List;

public record Graduation(List<Integer> rangeValues) implements SurveyOption {
}
