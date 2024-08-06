package BrennerSouza.NutriFitAPI.domain.mealfood;

import BrennerSouza.NutriFitAPI.domain.food.Food;
import BrennerSouza.NutriFitAPI.domain.meal.Meal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "mealfoods")
@Entity(name = "MealFood")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class MealFood {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;
    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;
    private Integer grams;

    public void updateDataMealFood(DataUpdateMealFood data) {
        this.grams = data.grams();
    }
}
