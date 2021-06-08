package calculadoraYStarWars.calculadoraYStarWars.repositories;

public class IngredienteRepository {
    private String name;
    private Integer calories;

    public IngredienteRepository() {
    }

    public IngredienteRepository(String name, Integer calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }
}
