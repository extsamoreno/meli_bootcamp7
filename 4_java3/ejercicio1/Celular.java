package ejercicio1;

public class Celular implements ejercicio1.Precedable<Celular>{
    private String titular;
    private int numero;

    public Celular(String titular, int numero) {
        this.titular = titular;
        this.numero = numero;
    }

    public Celular(){}

    public Celular(int numero) {
        this.numero = numero;
    }

    public String gettitular() {
        return titular;
    }

    public void settitular(String titular) {
        this.titular = titular;
    }

    public int getnumero() {
        return numero;
    }

    public void setnumero(int numero) {
        this.numero = numero;
    }

    @Override
    public int precedeA(Celular cel) {
        return this.getnumero() < cel.getnumero()? 1 : 0;
    }

    @Override
    public String toString() {
        return "Celular{" +
                "titular='" + titular + '\'' +
                ", numero=" + numero +
                '}';
    }
}