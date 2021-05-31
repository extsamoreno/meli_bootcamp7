package Practice.SaveTheRopa;

public abstract class Prenda {
    private String marca, modelo;

    public Prenda() {
    }

    public Prenda(String modelo, String marca) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Prenda(Prenda prenda) {
        this.modelo = prenda.getModelo();
        this.marca = prenda.getMarca();
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
        return "{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
