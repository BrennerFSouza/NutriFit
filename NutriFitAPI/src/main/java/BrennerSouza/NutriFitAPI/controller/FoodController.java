package BrennerSouza.NutriFitAPI.controller;

import BrennerSouza.NutriFitAPI.domain.food.DataCreateFood;
import BrennerSouza.NutriFitAPI.domain.food.Food;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("food")
public class FoodController {

    @GetMapping
    public String food(){
        var arroz = new Food();
        arroz.setName("arroz");


        return arroz.toString();
    }

    @PostMapping
    public void createFood(@RequestBody DataCreateFood data){
        System.out.println(data);
    }

}
