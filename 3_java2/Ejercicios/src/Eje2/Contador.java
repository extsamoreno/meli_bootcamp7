package Eje2;

public class Contador {
    private int valorActual;

    public int getValorActual() {
        return valorActual;
    }

    public void setValorActual(int valorActual) {
        this.valorActual = valorActual;
    }

    public void incrementar(){
        this.valorActual++;
    }

    public void decrementar(){
        this.valorActual--;
    }

    public Contador(){
        valorActual = 0;
    }

    public Contador(int valorActual){
        this.valorActual = valorActual;
    }

    public Contador(Contador c){
        this.valorActual = c.valorActual;
    }


}
