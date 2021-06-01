public class Celular implements Precedable<Celular>{
    private int celular;
    private String titular;

    public Celular(int celular, String titular) {
        this.celular = celular;
        this.titular = titular;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public  int precedeA(Celular celular){
        if(this.celular> celular.celular){
            return 1;
        }
        return 0;
    }
}
