CREATE TABLE survey(
    id           uuid          DEFAULT uuid_generate_v4(),
    name         VARCHAR(20)   NOT NULL,
    description  VARCHAR(256),
    status       VARCHAR(12)   NOT NULL,
    question     VARCHAR(256)  NOT NULL,
    votes        INTEGER       DEFAULT 0,
    PRIMARY KEY (id)
);

CREATE TABLE survey_option(
    id           uuid          DEFAULT uuid_generate_v4(),
    option       VARCHAR(256)  NOT NULL,
    survey_id    uuid,
    FOREIGN KEY (survey_id) REFERENCES survey,
    PRIMARY KEY (id)
);