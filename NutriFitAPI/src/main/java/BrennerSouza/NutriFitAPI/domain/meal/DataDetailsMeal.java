package BrennerSouza.NutriFitAPI.domain.meal;

import java.time.LocalDateTime;

public record DataDetailsMeal(
        Long id,
        Long idUser,
        String name,
        LocalDateTime dateTime
) {
    public DataDetailsMeal(Meal meal) {
        this(meal.getId(), meal.getUser().getId(), meal.getName(), meal.getDateTime());
    }
}
