package EjerciciosM;

public class Celular implements Precedable<Celular>{

    private String titular;
    private int numero;

    public Celular(String titular, int numero) {
        this.titular = titular;
        this.numero = numero;
    }

    @Override
    public int precedeA(Celular cel) {

        if(numero < cel.numero){
            return 1;
        }
        else{
            return 0;
        }
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
