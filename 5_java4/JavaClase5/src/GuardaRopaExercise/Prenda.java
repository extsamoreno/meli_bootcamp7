package GuardaRopaExercise;

public class Prenda {
    private String marca;
    private String modelo;

    public Prenda(String marca, String modelo)
    {
        this.setMarca(marca);
        this.setModelo(modelo);
    }

    private void setMarca(String marca)
    {
        this.marca = marca;
    }

    private void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    @Override
    public String toString() {
        return '"' + this.getMarca() + ": " + getModelo() + '"';
    }
}
