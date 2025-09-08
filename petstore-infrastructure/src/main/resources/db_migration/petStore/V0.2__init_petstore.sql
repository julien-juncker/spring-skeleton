CREATE TABLE pet_store(
    id         uuid          DEFAULT uuid_generate_v4(),
    name       VARCHAR(128)  NOT NULL,
    PRIMARY KEY (id)
);