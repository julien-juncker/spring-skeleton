CREATE TABLE pet(
    id      uuid        DEFAULT uuid_generate_v4(),
    name    VARCHAR(20) NOT NULL,
    type    VARCHAR(20) NOT NULL,
    age     INTEGER     NOT NULL,
    primary key (id)
);