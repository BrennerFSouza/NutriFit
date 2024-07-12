CREATE TABLE foods
(
    id                  BIGINT        NOT NULL AUTO_INCREMENT,
    name                VARCHAR(100)  NOT NULL,
    carbos              FLOAT         NOT NULL,
    proteins            FLOAT         NOT NULL,
    fats                FLOAT         NOT NULL,
    fibers              FLOAT         NOT NULL,
    measure_in_grams    FLOAT         NOT NULL,
    image VARCHAR(255),

    PRIMARY KEY (id)
);
