package JavaDay3.Ejercicio1;

public class Celular implements  Precedable<Celular>{
    private int numero;
    private Persona titular;


    public Celular(int numero, Persona titular) {
        this.numero = numero;
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }
    @Override
    public int precedeA(Celular celular) {
        if(this.numero > celular.getNumero()){
            return 1;
        }
        else return 0;
    }
}
