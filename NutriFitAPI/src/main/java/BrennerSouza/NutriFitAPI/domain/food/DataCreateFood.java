package BrennerSouza.NutriFitAPI.domain.food;

public record DataCreateFood(
        String name,
        Float carbo,
        Float proteins,
        Float fats,
        Float fibers,
        Integer measureInGrams,
        String image
) {
}
