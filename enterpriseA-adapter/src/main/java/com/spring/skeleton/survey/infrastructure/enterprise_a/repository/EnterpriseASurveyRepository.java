package com.spring.skeleton.survey.infrastructure.enterprise_a.repository;

import com.spring.skeleton.survey.infrastructure.enterprise_a.entities.SurveyDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EnterpriseASurveyRepository extends CrudRepository<SurveyDAO, UUID> {
}
