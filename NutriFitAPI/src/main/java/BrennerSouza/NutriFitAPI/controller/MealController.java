package BrennerSouza.NutriFitAPI.controller;

import BrennerSouza.NutriFitAPI.domain.meal.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("meal")
public class MealController {

    @Autowired
    private MealRepository repository;

    @Autowired
    private CreateMeal createMeal;

    @PostMapping
    @Transactional
    public ResponseEntity createMeal(@RequestBody @Valid DataCreateMeal data){
        var dto = createMeal.createMeal(data);

        return ResponseEntity.ok(dto);

    }

    @GetMapping("/listallusermeals")
    public ResponseEntity<List<DataDetailsMeal>> listAllUserMeal(@RequestBody @Valid DataListAllUserMealRequest data){
        var meals = repository.findAllMealsByUserIdAndDate(data.userId(),data.date());
        return ResponseEntity.ok(meals);
    }


    @GetMapping("/{id}")
    public ResponseEntity detailMeal(@PathVariable Long id){
        var meal = repository.getReferenceById(id);
        return ResponseEntity.ok(new DataDetailsMeal(meal));

    }


}
