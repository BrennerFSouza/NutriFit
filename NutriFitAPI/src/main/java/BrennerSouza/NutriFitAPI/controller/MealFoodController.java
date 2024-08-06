package BrennerSouza.NutriFitAPI.controller;

import BrennerSouza.NutriFitAPI.domain.mealfood.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mealfood")
public class MealFoodController {

    @Autowired
    private MealFoodRepository repository;

    @Autowired
    private CreateMealFood createMealFood;


    @PostMapping
    @Transactional
    public ResponseEntity createMealFood(@RequestBody @Valid DataCreateMealFood data) {

        var dto = createMealFood.createMealFood(data);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/listallmealfood/{mealid}")
    public ResponseEntity<List<DataDetailsMealFood>> listAllMealFood(@PathVariable Long mealid) {
        var mealFoods = repository.findAllMealFoodsByMealId(mealid);

        return ResponseEntity.ok(mealFoods);

    }

    @GetMapping("/{id}")
    public ResponseEntity detailMealFood(@PathVariable Long id) {

        var mealFood = repository.getReferenceById(id);
        return ResponseEntity.ok(new DataDetailsMealFood(mealFood));
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateMealFood(@RequestBody @Valid DataUpdateMealFood data) {
        var mealFood = repository.getReferenceById(data.id());
        mealFood.updateDataMealFood(data);

        return ResponseEntity.ok(new DataDetailsMealFood(mealFood));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteMealFood(@PathVariable Long id){
        var mealFood = repository.getReferenceById(id);
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }




}
