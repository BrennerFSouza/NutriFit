package BrennerSouza.NutriFit.domain.food;

public class Food {

    private Long id;
    private String name;
    private Double measureInGrams;
    private Double measureInSpoons;

    private Double protein;
    private Double carbohydrates;
    private Double fat;
    private Double fiber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMeasureInGrams() {
        return measureInGrams;
    }

    public void setMeasureInGrams(Double measureInGrams) {
        this.measureInGrams = measureInGrams;
    }

    public Double getMeasureInSpoons() {
        return measureInSpoons;
    }

    public void setMeasureInSpoons(Double measureInSpoons) {
        this.measureInSpoons = measureInSpoons;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getFiber() {
        return fiber;
    }

    public void setFiber(Double fiber) {
        this.fiber = fiber;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", measureInGrams=" + measureInGrams +
                ", measureInSpoons=" + measureInSpoons +
                ", protein=" + protein +
                ", carbohydrates=" + carbohydrates +
                ", fat=" + fat +
                ", fiber=" + fiber +
                '}';
    }
}
