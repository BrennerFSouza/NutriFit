CREATE TABLE mealfoods
(
    id             BIGINT        NOT NULL AUTO_INCREMENT,
    meal_id        BIGINT        NOT NULL,
    food_id        BIGINT        NOT NULL,
    grams          INTEGER       NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT fk_mealfood_meal_id FOREIGN KEY (meal_id) REFERENCES meals(id),
    CONSTRAINT fk_mealfood_food_id FOREIGN KEY (food_id) REFERENCES foods(id)
);
