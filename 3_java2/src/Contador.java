public class Contador {

    private Integer valor;

    public Contador() {
    }

    public Contador(Integer valor) {
        this.valor = valor;
    }

    public Contador(Contador contador) {
        this.valor = contador.getValor();
    }

    public void aumentarContador(){
        this.valor++;
    }

    public void disminuirValor(){
        this.valor--;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
}
