package BrennerSouza.NutriFitAPI.controller;

import BrennerSouza.NutriFitAPI.domain.food.Food;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("foods")
public class FoodController {

    @GetMapping
    public String food(){
        var arroz = new Food();
        arroz.setName("arroz");


        return arroz.toString();
    }

}
