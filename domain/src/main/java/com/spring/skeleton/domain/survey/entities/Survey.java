package com.spring.skeleton.domain.survey.entities;

import com.spring.skeleton.domain.survey.value_objects.SurveyOption;

public record Survey(
        String enterpriseName,
        String name,
        String description,
        String status,
        String question,
        SurveyOption options,
        Integer votes) {

    public static class Builder {
        private String enterpriseName;
        private String name;
        private String description;
        private String status;
        private String question;
        private SurveyOption options;
        private Integer votes;

        public Builder withEnterpriseName(final String enterpriseName) {
            this.enterpriseName = enterpriseName;
            return this;
        }

        public Builder withName(final String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(final String description) {
            this.description = description;
            return this;
        }

        public Builder withStatus(final String status) {
            this.status = status;
            return this;
        }

        public Builder withQuestion(final String question) {
            this.question = question;
            return this;
        }

        public Builder withOptions(final SurveyOption options) {
            this.options = options;
            return this;
        }

        public Builder withVotes(final Integer votes) {
            this.votes = votes;
            return this;
        }

        public Survey build() {
            return new Survey(this.enterpriseName, this.name, this.description, this.status, this.question, this.options, this.votes);
        }
    }
}
