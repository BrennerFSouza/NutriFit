package BrennerSouza.NutriFitAPI.domain.meal;

import BrennerSouza.NutriFitAPI.domain.food.DataDetailsFood;

import java.time.LocalDateTime;
import java.util.List;

public record DataDetailsMealWithFood(
        Long mealId,
        String mealName,
        LocalDateTime dateTime,
        Long userId,
        List<FoodDetailDTO> foods) {

    public DataDetailsMealWithFood(Meal meal, List<FoodDetailDTO> foods) {
        this(meal.getId(), meal.getName(), meal.getDateTime(), meal.getUser().getId(), foods);
    }

    public record FoodDetailDTO(
            Long mealFoodId,
            Integer grams,
            Long foodId,
            String foodName,


            Double carbos,
            Double Proteins,
            Double fats,
            Double fibers,
            Integer measureInGrams,
            String image
            ){}


}
