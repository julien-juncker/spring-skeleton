package com.spring.skeleton.configuration;

import com.spring.skeleton.domain.survey.SurveyService;
import com.spring.skeleton.domain.survey.port.SurveyPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BeanConfiguration {

    @Bean
    public SurveyService surveyService(final List<SurveyPort> surveyPort) {
        return new SurveyService(surveyPort);
    }
}
