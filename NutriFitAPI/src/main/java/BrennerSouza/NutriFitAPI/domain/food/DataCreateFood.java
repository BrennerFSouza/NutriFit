package BrennerSouza.NutriFitAPI.domain.food;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataCreateFood(
        @NotBlank
        String name,
        @NotNull
        @DecimalMin(value = "0.0", inclusive = false)
        @DecimalMax(value = "1000.0", inclusive = true)
        Double carbos,
        @NotNull
        @DecimalMin(value = "0.0", inclusive = false)
        @DecimalMax(value = "1000.0", inclusive = true)
        Double proteins,
        @NotNull
        @DecimalMin(value = "0.0", inclusive = false)
        @DecimalMax(value = "1000.0", inclusive = true)
        Double fats,
        @NotNull
        @DecimalMin(value = "0.0", inclusive = false)
        @DecimalMax(value = "1000.0", inclusive = true)
        Double fibers,
        @NotNull
        @DecimalMin(value = "0", inclusive = false)
        @DecimalMax(value = "1000", inclusive = true)
        Integer measureInGrams,
        String image
) {

}
