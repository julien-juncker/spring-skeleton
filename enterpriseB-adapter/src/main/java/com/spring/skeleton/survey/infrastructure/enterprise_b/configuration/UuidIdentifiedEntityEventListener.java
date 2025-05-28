package com.spring.skeleton.survey.infrastructure.enterprise_b.configuration;

import com.spring.skeleton.survey.infrastructure.enterprise_b.entities.SurveyDAO;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

import java.util.UUID;

public class UuidIdentifiedEntityEventListener extends AbstractMongoEventListener<SurveyDAO> {

    @Override
    public void onBeforeConvert(BeforeConvertEvent<SurveyDAO> event) {

        super.onBeforeConvert(event);
        final var entity = event.getSource();

        if (entity.getId() == null) {
            entity.setId(UUID.randomUUID());
        }
    }
}
