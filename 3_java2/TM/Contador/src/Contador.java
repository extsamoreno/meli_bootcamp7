public class Contador {
    private int contador;

    // getter
    public int obtenerContador () {
        return contador;
    }

    // setter
    public void establecerContador (int contador) {
        this.contador = contador;
    }

    // constructor con parámetro(s)
    public Contador (int contadorInicial) {
        if (contadorInicial > 0) {
            contador = contadorInicial;
        }
    }

    // constructor copiador
    public Contador (Contador contador) {
        this.contador = contador.obtenerContador();
    }

}