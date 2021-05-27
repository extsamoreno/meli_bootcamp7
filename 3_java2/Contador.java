public class Contador {
    private int valor;


    //CONTRUCTOR
    public Contador(int valor) {
        this.valor = valor;
    }
    public Contador() {
    }

    public Contador(Contador contador) {
        valor = contador.getValor();
    }



    //GET AND SET
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }


    //METODOS PARA INCREMENTAR Y DECREMENTAR
    public void incrementar(int cuanto){
        this.valor +=cuanto;
    }

    public void decrementar( int cuanto){
        this.valor -= cuanto;
    }



}
