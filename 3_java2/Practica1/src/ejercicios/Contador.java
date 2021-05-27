package ejercicios;

public class Contador {

    // Atributos
    private int valor;

    // Contructores
    public Contador(){
        this.valor = 0;
    }

    public Contador(int valor) {
        this.valor = valor;
    }

    public Contador(Contador c){
        this.valor = c.valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void incrementar(){
        valor += 1;
    }

    public void decrementar(){
        valor -= 1;
    }
}
