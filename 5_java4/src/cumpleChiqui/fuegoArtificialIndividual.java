package cumpleChiqui;

public class fuegoArtificialIndividual implements fuegoArtificial{
    private String sonido;
    @Override
    public void setSonidoAlExplotar(String sonido) {
        this.sonido = sonido;
    }

    @Override
    public void getSonidoAlExplotar() {
        System.out.println(this.sonido);
    }
}
