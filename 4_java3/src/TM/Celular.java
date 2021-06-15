package TM;

public class Celular<t> implements Precedable<Celular>{
    private int numero;
    private String titular;

    public Celular(String titular, int numero) {
        this.titular = titular;
        this.numero = numero;
    }

    public int getNumero() {
        return this.numero;
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

    // Recibe un generic y casteo luego dentro de precedeA
    @Override
    public int precedeA(Celular t) {
        if(this.numero > t.getNumero())
            return 1;
        return 0;
    }
}
