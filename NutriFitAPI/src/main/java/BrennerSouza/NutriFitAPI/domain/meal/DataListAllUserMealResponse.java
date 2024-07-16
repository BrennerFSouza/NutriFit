package BrennerSouza.NutriFitAPI.domain.meal;

import java.time.LocalDateTime;

public record DataListAllUserMealResponse(
        Long id,
        String name,
        LocalDateTime dateTime
) {
}
