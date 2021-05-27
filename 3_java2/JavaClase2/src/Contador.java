public class Contador {
    private int valor;

    public Contador(){}
    public Contador(int valor){
        this.valor = valor;
    }
    public Contador(Contador copia){
        this.valor = copia.getValor();
    }

    public int getValor(){
        return this.valor;
    }

    public void setValor(int valor){
        this.valor = valor;
    }

    public void incrementar(int paso){
        this.valor += paso;
    }

    public void decrementar(int paso){
        this.valor -= paso;
    }
}
