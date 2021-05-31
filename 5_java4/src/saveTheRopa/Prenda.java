package saveTheRopa;

public class Prenda {
    String marca,modelo;

    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return modelo + " " + marca;
    }
}
