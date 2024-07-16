package BrennerSouza.NutriFitAPI.domain.meal;

import BrennerSouza.NutriFitAPI.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "meals")
@Entity(name = "Meal")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Meal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String name;

    private LocalDateTime dateTime;


    public void updateDataMeal(DataUpdateMeal data) {
        if (data.name() != null){
            this.name = data.name();
        }
        if (data.dateTime() != null){
            this.dateTime = data.dateTime();
        }
    }
}
