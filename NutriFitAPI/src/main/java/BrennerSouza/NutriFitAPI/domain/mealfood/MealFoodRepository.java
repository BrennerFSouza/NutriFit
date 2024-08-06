package BrennerSouza.NutriFitAPI.domain.mealfood;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MealFoodRepository extends JpaRepository<MealFood, Long> {


    @Query("SELECT mf FROM MealFood mf WHERE mf.meal.id = :mealId")
    List<DataDetailsMealFood> findAllMealFoodsByMealId(Long mealId);
}
