package com.spring.skeleton.apps.integration;

import com.intuit.karate.junit5.Karate;
import com.spring.skeleton.apps.configuration.ApplicationStub;

class SurveyTest extends ApplicationStub {

    @Karate.Test
    Karate testSurvey() {
        return Karate.run("classpath:scenarii/survey/survey.feature");
    }
}
