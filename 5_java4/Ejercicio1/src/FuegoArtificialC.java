public class FuegoArtificialC implements FuegoArtificial{

    private String nombre;

    public FuegoArtificialC() {
        this.nombre = "Fuego Artificial C";
    }

    @Override
    public void explotar() {
        System.out.println("KABUM!!!");
    }
}
