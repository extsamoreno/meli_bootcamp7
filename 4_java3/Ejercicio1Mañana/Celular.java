package Ejercicio1Mañana;

public class Celular implements Precedable<Celular> {
    private int numero;
    private String titular;

    //contructor

    public Celular(){}

    public Celular(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }

    //get and set
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


    //metodos
    @Override
    public int precedeA(Celular t) {
        if(this.numero > t.getNumero()){
            return  1;
        }

        return 0;
    }

}
