public class Celular implements Precedable<Celular>{

    private int numero;
    private String titular;

    public Celular(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }

    @Override
    public int precedeA(Celular celular) {
        return (this.numero - celular.numero);
    }

    @Override
    public String toString() {
        return "Celular{" +
                "numero=" + numero +
                ", titular='" + titular + '\'' +
                '}';
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
}
/*Crear la clase Celular, con los atributos: número y titular, implementar
Precedable<Celular> y proceder del mismo modo que lo hicimos con Persona a partir del punto anterior.
*/