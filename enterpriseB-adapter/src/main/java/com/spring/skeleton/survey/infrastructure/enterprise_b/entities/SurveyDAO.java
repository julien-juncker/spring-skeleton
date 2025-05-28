package com.spring.skeleton.survey.infrastructure.enterprise_b.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = "survey")
public class SurveyDAO {
    @Id
    private UUID id;

    private String name;

    private String description;

    private String status;

    private String question;

    private List<Integer> options;

    private Integer votes;

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(final String question) {
        this.question = question;
    }

    public List<Integer> getOptions() {
        return options;
    }

    public void setOptions(final List<Integer> options) {
        this.options = options;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(final Integer votes) {
        this.votes = votes;
    }
}
