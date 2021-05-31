public class FuegoArtificialB implements FuegoArtificial{

    private String nombre;

    public FuegoArtificialB() {
        this.nombre = "Fuego Artificial B";
    }

    @Override
    public void explotar() {
        System.out.println("PIM PAM!!!");
    }
}
