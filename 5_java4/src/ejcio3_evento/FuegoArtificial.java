package ejcio3_evento;

public abstract class FuegoArtificial {

    private String id;

    public FuegoArtificial(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract void explotar();

    public abstract void mostrarId();

}
