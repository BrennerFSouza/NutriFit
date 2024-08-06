package BrennerSouza.NutriFitAPI.domain.mealfood;

import jakarta.validation.constraints.NotNull;

public record DataCreateMealFood(
        @NotNull
        Long mealId,
        @NotNull
        Long foodId,
        @NotNull
        Integer grams
) {
}
