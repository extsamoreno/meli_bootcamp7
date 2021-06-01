package ejercicios.martegroup;

public class FuegoArtificialIndividual implements FuegoArtificial{
    String ruido;

    public FuegoArtificialIndividual(String ruido) {
        this.ruido = ruido;
    }

    @Override
    public void explotar() {
        System.out.println(ruido);
    }
}
