package BrennerSouza.NutriFitAPI.controller;

import BrennerSouza.NutriFitAPI.domain.food.DataDetailsFood;
import BrennerSouza.NutriFitAPI.domain.food.Food;
import BrennerSouza.NutriFitAPI.domain.food.FoodRepository;
import BrennerSouza.NutriFitAPI.domain.meal.*;
import BrennerSouza.NutriFitAPI.domain.mealfood.DataDetailsMealFood;
import BrennerSouza.NutriFitAPI.domain.mealfood.MealFood;
import BrennerSouza.NutriFitAPI.domain.mealfood.MealFoodRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("meal")
public class MealController {

    @Autowired
    private MealRepository repository;

    @Autowired
    private MealFoodRepository mealFoodRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private CreateMeal createMeal;

    @PostMapping
    @Transactional
    public ResponseEntity createMeal(@RequestBody @Valid DataCreateMeal data) {
        var dto = createMeal.createMeal(data);

        return ResponseEntity.ok(dto);

    }

    @GetMapping("/listallusermeals")
    public ResponseEntity<List<DataDetailsMeal>> listAllUserMeal(@RequestBody @Valid DataListAllUserMealRequest data) {
        var meals = repository.findAllMealsByUserIdAndDate(data.userId(), data.date());
        return ResponseEntity.ok(meals);
    }


    @GetMapping("/{id}")
    public ResponseEntity detailMeal(@PathVariable Long id) {
        var meal = repository.getReferenceById(id);
        return ResponseEntity.ok(new DataDetailsMeal(meal));

    }

    @GetMapping("/{id}/detail")
    public ResponseEntity detailMealWithFoods(@PathVariable Long id) {
        var meal = repository.getReferenceById(id);

        List<DataDetailsMealFood> mealFoods = mealFoodRepository.findAllMealFoodsByMealId(meal.getId());


        List<DataDetailsMealWithFood.FoodDetailDTO> foodDetails = mealFoods.stream().map(mealFood -> {
            Optional<Food> food = foodRepository.findById(mealFood.foodId());
            return new DataDetailsMealWithFood.FoodDetailDTO(
                    mealFood.id(),
                    mealFood.grams(),
                    food.get().getId(),
                    food.get().getName(),
                    food.get().getCarbos(),
                    food.get().getProteins(),
                    food.get().getFats(),
                    food.get().getFibers(),
                    food.get().getMeasureInGrams(),
                    food.get().getImage()
            );
        }).collect(Collectors.toList());

        DataDetailsMealWithFood details = new DataDetailsMealWithFood(meal, foodDetails);

        return ResponseEntity.ok(details);


    }

    @PutMapping
    @Transactional
    public ResponseEntity updateMeal(@RequestBody @Valid DataUpdateMeal data) {
        var meal = repository.getReferenceById(data.id());
        meal.updateDataMeal(data);
        return ResponseEntity.ok(new DataDetailsMeal(meal));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public  ResponseEntity deleteMeal(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }


}
