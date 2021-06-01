package Exercise3;

public class FuegoArtificialIndividual extends FuegoArtificial {
    public FuegoArtificialIndividual(String id, String ruido) {
        super(id);
        this.ruido = ruido;
    }

    public String getRuido() {
        return ruido;
    }

    public void setRuido(String ruido) {
        this.ruido = ruido;
    }

    private String ruido;
    @Override
    public void explotar() {
        System.out.println(ruido);
    }
}
