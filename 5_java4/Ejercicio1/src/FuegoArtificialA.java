public class FuegoArtificialA implements FuegoArtificial{

    private String nombre;

    public FuegoArtificialA() {
        this.nombre = "Fuego Artificial A";
    }

    @Override
    public void explotar() {
        System.out.println("PUM PUM !!!");
    }
}
