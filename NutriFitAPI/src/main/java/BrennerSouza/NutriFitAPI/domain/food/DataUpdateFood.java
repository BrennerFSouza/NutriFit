package BrennerSouza.NutriFitAPI.domain.food;

import jakarta.validation.constraints.NotNull;

public record DataUpdateFood(
        @NotNull
        Long id,
        String name,
        Double carbos,
        Double proteins,
        Double fats,
        Double fibers,
        Integer measureInGrams,
        String image
) {
}
