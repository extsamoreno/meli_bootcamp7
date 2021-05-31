public class Prenda {
    String marca, modelo;

    public Prenda() {
    }

    public Prenda(String marca, String modelo) {
        this.modelo = modelo;
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return " marca: " + marca + "  modelo: " + modelo;
    }
}
