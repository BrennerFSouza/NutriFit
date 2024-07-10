package BrennerSouza.NutriFitAPI.controller;

import BrennerSouza.NutriFitAPI.domain.food.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("food")
public class FoodController {
    @Autowired
    private FoodRepository repository;


    @PostMapping
    @Transactional
    public ResponseEntity createFood(@RequestBody @Valid DataCreateFood data, UriComponentsBuilder uriBuilder) {

        var food = new Food(data);
        repository.save(food);
        System.out.println(new Food(data));

        var uri = uriBuilder.path("/food/{id}").buildAndExpand(food.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataDetailsFood(food));


    }

    @GetMapping
    public ResponseEntity<Page<DataFoodList>> listAllFoods(Pageable pageable) {
        var page = repository.findAll(pageable).map(DataFoodList::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateFood(@RequestBody @Valid DataUpdateFood data) {
        var food = repository.getReferenceById(data.id());
        food.updateFoodData(data);

        return ResponseEntity.ok(new DataDetailsFood(food));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteFood(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();

    }


}
