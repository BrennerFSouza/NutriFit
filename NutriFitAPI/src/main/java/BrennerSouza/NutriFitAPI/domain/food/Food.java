package BrennerSouza.NutriFitAPI.domain.food;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "foods")
@Entity(name = "Food")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer measureInGrams;

    private Double carbos;
    private Double proteins;
    private Double fats;
    private Double fibers;
    private String image;

    public Food(DataCreateFood data) {
        this.name = data.name();
        this.carbos = data.carbos();
        this.proteins = data.proteins();
        this.fats = data.fats();
        this.fibers = data.fibers();
        this.measureInGrams = data.measureInGrams();
        this.image = data.image();
    }


    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", measureInGrams=" + measureInGrams +
                ", protein=" + proteins +
                ", carbohydrates=" + carbos +
                ", fat=" + fats +
                ", fiber=" + fibers +
                '}';
    }

    public void updateFoodData(DataUpdateFood data) {
        if (data.name() != null){
            this.name = data.name();
        }
        if (data.measureInGrams() != null){
            this.measureInGrams = data.measureInGrams();
        }
        if (data.carbos() != null){
            this.carbos = data.carbos();
        }
        if (data.proteins() != null){
            this.proteins = data.proteins();
        }
        if (data.fats() != null){
            this.fats = data.fats();
        }
        if (data.fibers() != null){
            this.fibers = data.fibers();
        }
        if (data.image() != null){
            this.image = data.image();
        }


    }
}
