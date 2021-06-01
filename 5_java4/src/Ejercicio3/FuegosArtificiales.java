package Ejercicio3;

public abstract class FuegosArtificiales {
    protected String ruido;

    public String getRuido() {
        return ruido;
    }

    public void setRuido(String ruido) {
        this.ruido = ruido;
    }

    public void explotar() {
        System.out.println(this.ruido);
    }

}
