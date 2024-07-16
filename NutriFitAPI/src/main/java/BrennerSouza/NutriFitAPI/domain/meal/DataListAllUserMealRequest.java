package BrennerSouza.NutriFitAPI.domain.meal;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DataListAllUserMealRequest(
        @NotNull
        Long userId,
        @NotNull
        LocalDate date

) {

}
