package BrennerSouza.NutriFitAPI.domain.meal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DataCreateMeal(
        @NotNull
        Long idUser,
        @NotBlank
        String name,
        @NotNull
        LocalDateTime dateTime
) {
}
