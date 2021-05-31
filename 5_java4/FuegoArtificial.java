public abstract class FuegoArtificial {
    private String ruido;

    public FuegoArtificial() {
    }

    public FuegoArtificial(String ruido) {
        this.ruido = ruido;
    }

    public void explotar(){
        System.out.println(this.ruido);
    }

    public String getRuido() {
        return ruido;
    }

    public void setRuido(String ruido) {
        this.ruido = ruido;
    }
}
