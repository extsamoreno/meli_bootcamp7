public class Contador {
    private int conteo;

    public int getConteo() {
        return conteo;
    }

    public void setConteo(int conteo) {
        this.conteo = conteo;
    }

    public Contador(int conteo) {
        this.conteo = conteo;
    }
    public Contador() {
    }

    public Contador(Contador pcontador) {
        conteo = pcontador.getConteo();
    }
    public void incrementar(){
        conteo++;
    }
    public void decrementar(){
        conteo--;
    }
    public void incrementar(int pvalor){
        conteo = conteo+ pvalor;
    }
    public void decrementar(int pvalor){
        conteo = conteo - pvalor;
    }
}
