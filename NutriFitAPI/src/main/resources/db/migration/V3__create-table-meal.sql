CREATE TABLE meals
(
    id             BIGINT        NOT NULL AUTO_INCREMENT,
    user_id        BIGINT        NOT NULL,
    name           VARCHAR(100)  NOT NULL,
    date_time      DATETIME  NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT fk_meal_user_id FOREIGN KEY (user_id) REFERENCES users(id)
);
