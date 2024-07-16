package BrennerSouza.NutriFitAPI.domain.meal;

import BrennerSouza.NutriFitAPI.domain.ValidateUserException;
import BrennerSouza.NutriFitAPI.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateMeal {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private UserRepository userRepository;

    public DataDetailsMeal createMeal(DataCreateMeal data){
        if (!userRepository.existsById(data.idUser())){
            throw new ValidateUserException("User id not found!");
        }

        var user = userRepository.findById(data.idUser()).get();
        var meal = new Meal(null,user, data.name(), data.dateTime());
        mealRepository.save(meal);

        return new DataDetailsMeal(meal);
    }


}
