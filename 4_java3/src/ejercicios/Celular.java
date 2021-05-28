package ejercicios;

public class Celular implements Precedable<Celular> {

    private String titular;
    private int numero;

    public Celular(String titular, int numero) {
        this.numero=numero;
        this.titular=titular;
    }

    public String getTitular() { return titular;}

    public void setTitular(String titular) { this.titular = titular;}

    public int getNumero() { return numero;}

    public void setNumero(int numero) { this.numero = numero;}

    @Override
    public int precedeA (Celular c){

        if (this.numero<c.getNumero()) return -1;
        if (this.numero>c.getNumero()) return 1;
        return 0;

    }
    @Override
    public String toString() {
        return  "{ titular : '" + this.titular + "', numero : '" + this.numero + "' }";
    }
}