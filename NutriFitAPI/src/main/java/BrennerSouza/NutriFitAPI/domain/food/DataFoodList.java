package BrennerSouza.NutriFitAPI.domain.food;

public record DataFoodList (
        Long id,
        String name,
        Double carbos,
        Double proteins,
        Double fats,
        Double fibers,
        Integer measureInGrams,
        String image
){
    public DataFoodList(Food food){
        this(food.getId(), food.getName(), food.getCarbos(), food.getProteins(), food.getFats(), food.getFibers(), food.getMeasureInGrams(),food.getImage());
    }
}
