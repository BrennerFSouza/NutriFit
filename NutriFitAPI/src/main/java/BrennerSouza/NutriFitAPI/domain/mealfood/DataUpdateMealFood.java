package BrennerSouza.NutriFitAPI.domain.mealfood;

import jakarta.validation.constraints.NotNull;

public record DataUpdateMealFood(
        @NotNull
        Long id,
        @NotNull
        Long mealId,
        @NotNull
        Long foodId,
        @NotNull
        Integer grams
) {
}
