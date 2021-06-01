package ejcio3_evento;

public class FuegoArtificialIndividual extends FuegoArtificial {

    private String sonido;

    // Getters & Setters
    public String getSonido() {
        return sonido;
    }

    public void setSonido(String sonido) {
        this.sonido = sonido;
    }

    public FuegoArtificialIndividual(String id, String sonido) {
        super(id);
        this.sonido = sonido;
    }

    @Override
    public void explotar() {
        System.out.println(sonido);
    }

    @Override
    public void mostrarId() {
        System.out.println("Id: " + this.getId());
    }
}
