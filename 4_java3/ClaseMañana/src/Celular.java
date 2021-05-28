public class Celular implements Precedable<Celular>{
    private String numero;

    public Celular() {
    }

    public Celular(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public int precedeA(Celular celular) {
        return this.getNumero().compareTo(celular.getNumero());
    }

    @Override
    public String toString() {
        return "Celular{" +
                "numero='" + numero + '\'' +
                '}';
    }
}
