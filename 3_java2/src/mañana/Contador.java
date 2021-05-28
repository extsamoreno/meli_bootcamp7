package mañana;

public class Contador {

    private int valor;

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    //constructores
    public Contador(){}

    public Contador(int valor){
        this.valor = valor;
    }

    public Contador(Contador contador){
        this.valor = contador.valor;
    }

    //metodos
    public void incrementar(int valor){
        this.valor += valor;
    }

    public void decrementar(int valor){
        this.valor -= valor;
    }



}
