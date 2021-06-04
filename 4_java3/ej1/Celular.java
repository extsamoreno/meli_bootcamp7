package ejercitacionMañana.ej1;

public class Celular implements Precedable<Celular>{
    int numero;
    String titular;

    public Celular(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    @Override
    public int precedeA(Celular celular) {
        if (this.numero > celular.getNumero())
            return 1;
        else
            return 0;
    }
}
