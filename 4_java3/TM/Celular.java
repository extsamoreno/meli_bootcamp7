public class Celular implements Precedable<Celular>{
    int numero;
    String titular;

    public Celular(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }

    //region Getters and Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public int precedeA(Celular cel) {
        if(this.numero > cel.numero)
            return 1;
        else
            return 0;
    }

    //endregion
}
