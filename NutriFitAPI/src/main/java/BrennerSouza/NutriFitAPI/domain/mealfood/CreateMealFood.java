package BrennerSouza.NutriFitAPI.domain.mealfood;

import BrennerSouza.NutriFitAPI.domain.ValidateUserException;
import BrennerSouza.NutriFitAPI.domain.food.FoodRepository;
import BrennerSouza.NutriFitAPI.domain.meal.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateMealFood {
    @Autowired
    private MealFoodRepository mealFoodRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private FoodRepository foodRepository;


    public DataDetailsMealFood createMealFood(DataCreateMealFood data) {
        if (!mealRepository.existsById(data.mealId())){
            throw new ValidateUserException("Meal id not found!");
        }

        if (!foodRepository.existsById(data.foodId())){
            throw new ValidateUserException("Food id not found!");
        }

        var meal = mealRepository.findById(data.mealId()).get();
        var food = foodRepository.findById(data.foodId()).get();
        var mealFood = new MealFood(null, meal, food, data.grams());

        mealFoodRepository.save(mealFood);

        return new DataDetailsMealFood(mealFood);

    }
}
