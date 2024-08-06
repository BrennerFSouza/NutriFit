package BrennerSouza.NutriFitAPI.domain.mealfood;

public record DataDetailsMealFood(
        Long id,
        Long mealId,
        Long foodId,
        Integer grams
) {
    public DataDetailsMealFood(MealFood mealFood) {
        this(mealFood.getId(), mealFood.getMeal().getId(),mealFood.getFood().getId(),mealFood.getGrams());
    }
}
