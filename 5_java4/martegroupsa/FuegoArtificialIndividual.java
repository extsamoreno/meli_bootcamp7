package martegroupsa;

public class FuegoArtificialIndividual implements martegroupsa.FuegoArtificial{
    private String ruido;

    public FuegoArtificialIndividual(String ruido) {
        this.ruido = ruido;
    }

    @Override
    public void explotar() {
        System.out.println(ruido);
    }
}