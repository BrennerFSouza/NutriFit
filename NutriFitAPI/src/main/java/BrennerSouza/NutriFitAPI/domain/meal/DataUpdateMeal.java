package BrennerSouza.NutriFitAPI.domain.meal;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DataUpdateMeal (
        @NotNull
        Long id,
        String name,
        LocalDateTime dateTime
){
}
