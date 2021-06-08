package calculadoraYStarWars.calculadoraYStarWars.dto;

public class IngredienteRequestDTO {
    private String nombre;
    private double peso;

    public IngredienteRequestDTO() {
    }

    public IngredienteRequestDTO(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
