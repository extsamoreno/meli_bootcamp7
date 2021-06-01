public class Prenda {

    String marca;
    String modelo;

    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Prenda{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Prenda p = new Prenda("a","b");

        System.out.println(p);
    }
}
