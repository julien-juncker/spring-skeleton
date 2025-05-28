package com.spring.skeleton.survey.infrastructure.enterprise_a.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import org.hibernate.annotations.Cascade;

import java.util.List;
import java.util.UUID;

@Entity(name="survey")
public class SurveyDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String question;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="survey_id", nullable = false)
    private List<SurveyOptionDAO> options;

    @Column
    private Integer votes;

    @PrePersist
    public void prePersist() {
        if (votes == null) {
            votes = 0;
        }
    }

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

    public List<SurveyOptionDAO> getOptions() {
        return options;
    }

    public void setOptions(final List<SurveyOptionDAO> options) {
        this.options = options;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(final Integer votes) {
        this.votes = votes;
    }
}
