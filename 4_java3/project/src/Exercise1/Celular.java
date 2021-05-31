package Exercise1;

public class Celular implements Precedable<Celular>{
    private String numero, titular;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public int precedeA(Celular celular) {
        return this.numero.compareTo(celular.getNumero());
    }
}
