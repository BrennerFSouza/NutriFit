package BrennerSouza.NutriFit.domain.food;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

    @GetMapping("/food")
    public String food(){
        var arroz = new Food();
        arroz.setName("arroz");


        return arroz.toString();
    }

}
