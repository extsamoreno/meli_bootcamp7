package Ex1;

public class Prenda {

    private String marca;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    private String modelo;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Prenda() {
    }

    @Override
    public String toString(){
        return "La marca es :" +this.getMarca() +" y el modelo es : " +this.getModelo() + ".";
    }
}
