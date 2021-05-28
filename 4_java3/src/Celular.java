public class Celular implements Precedable<Celular>{

    private int numero;
    private String titular;

    public Celular() {
    }

    public Celular(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }

    @Override
    public int precedeAt(Celular celular) {
        int resultado = 0;
        if (this.numero < celular.numero)
            resultado = -1;
        else if (this.numero > celular.numero)
            resultado = 1;
        else if (this.numero == celular.numero)
            resultado = 0;
        return resultado;
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
