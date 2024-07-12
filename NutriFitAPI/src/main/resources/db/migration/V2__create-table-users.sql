CREATE TABLE users
(
    id             BIGINT        NOT NULL AUTO_INCREMENT,
    login          VARCHAR(100)  NOT NULL UNIQUE,
    password       VARCHAR(100)  NOT NULL,
    name           VARCHAR(100)  NOT NULL,
    birth_date      DATE NOT NULL,
    gender         VARCHAR(1) NOT NULL,

    PRIMARY KEY (id)
);
