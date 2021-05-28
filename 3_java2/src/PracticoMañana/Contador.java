public class Contador {
    int nro;

    Contador(){
        this.nro = 0;
    }

    Contador(int nro){
        this.nro = nro;
    }

    Contador(Contador c){
        this.nro = c.nro;
    }

    void incrementar(){
        this.nro += 1;
    }

    void incrementar(int n){
        this.nro += n;
    }

    void decrementar(){
        this.nro -= 1;
    }

    void decrementar(int n){
        this.nro -= n;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }
}
