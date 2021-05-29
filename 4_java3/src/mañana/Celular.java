package mañana;

public class Celular implements Precedable<Celular> {
    private int numero;
    private String titular;

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public Celular(){}
    public Celular(int numero, String titular){
        this.numero= numero;
        this.titular =  titular;
    }

    @Override
    public int precedeA(Celular celular) {
        if(this.numero > celular.getNumero()){
            return 1;
        }else{
            return 0;
        }
    }
}
