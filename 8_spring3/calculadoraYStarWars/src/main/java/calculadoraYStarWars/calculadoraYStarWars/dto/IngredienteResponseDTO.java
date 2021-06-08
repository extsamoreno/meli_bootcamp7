package calculadoraYStarWars.calculadoraYStarWars.dto;

public class IngredienteResponseDTO {
    private String nombre;
    private int calorias;

    public IngredienteResponseDTO(){}

    public IngredienteResponseDTO(String nombre, int calorias) {
        this.nombre = nombre;
        this.calorias = calorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }
}
