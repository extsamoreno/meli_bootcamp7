public class Contador {
    private int valor;

    public Contador(){
    }

    public Contador(int valor){
        this.valor = valor;
    }

    public Contador(Contador copia){
        this.setValor(copia.getValor());
    }

    public int getValor(){
        return this.valor;
    }

    public void setValor(int valor){
        this.valor = valor;
    }

    public void incrementar(int paso){
        this.setValor(this.getValor() + paso);
    }

    public void decrementar(int paso){
        this.setValor(this.getValor() - paso);
    }
}
