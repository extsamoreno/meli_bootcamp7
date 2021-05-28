public class Celular implements Precedable<Celular>{
    private int numero;
    private String titular;

    public Celular(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Celular{" +
                "numero=" + numero +
                ", titular='" + titular + '\'' +
                '}';
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

    @Override
    public int precedeAt(Celular celular) {
        return this.getNumero()  - celular.getNumero();
    }
}
