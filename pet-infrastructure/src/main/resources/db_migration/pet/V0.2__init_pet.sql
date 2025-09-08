CREATE TABLE owner_address(
    number     INTEGER        NOT NULL,
    street     VARCHAR(256)   NOT NULL,
    city       VARCHAR(50)            ,
    state      VARCHAR(50)            ,
    zip        VARCHAR(50)    NOT NULL,
    PRIMARY KEY (number, street, zip)
);

CREATE TABLE owner(
    id             uuid          DEFAULT uuid_generate_v4(),
    first_name      VARCHAR(50)   NOT NULL,
    last_name       VARCHAR(50)   NOT NULL,
    address_number INTEGER       NOT NULL,
    address_street VARCHAR(256)  NOT NULL,
    address_zip    VARCHAR(50)   NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (first_name, last_name),
    FOREIGN KEY (address_number, address_street, address_zip)
        REFERENCES owner_address (number, street, zip)
);

CREATE TABLE pet(
    tag          uuid          DEFAULT uuid_generate_v4(),
    name         VARCHAR(20)   NOT NULL,
    type         VARCHAR(20)   NOT NULL,
    breed        VARCHAR(20)   NOT NULL,
    owner_id     uuid          NOT NULL,
    PRIMARY KEY (tag),
    FOREIGN KEY (owner_id) REFERENCES owner (id)
);