package BrennerSouza.NutriFitAPI.domain.meal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {

    @Query("SELECT m FROM Meal m WHERE m.user.id = :userId AND DATE(m.dateTime) = :date")
    List<DataDetailsMeal> findAllMealsByUserIdAndDate(Long userId, LocalDate date);
}
