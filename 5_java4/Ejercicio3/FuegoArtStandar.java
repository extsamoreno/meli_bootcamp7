public class FuegoArtStandar implements IFuegoArtifical{

    String ruido;

    public FuegoArtStandar(String ruido) {
        this.ruido = ruido;
    }

    @Override
    public void explotar() {
        System.out.println(" " + ruido);
    }
}
