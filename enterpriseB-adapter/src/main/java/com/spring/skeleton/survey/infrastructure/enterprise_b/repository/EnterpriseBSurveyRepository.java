package com.spring.skeleton.survey.infrastructure.enterprise_b.repository;

import com.spring.skeleton.survey.infrastructure.enterprise_b.entities.SurveyDAO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnterpriseBSurveyRepository extends MongoRepository<SurveyDAO, String> {
}
