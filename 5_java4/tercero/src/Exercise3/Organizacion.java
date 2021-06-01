package Exercise3;

public class Organizacion {
    private Evento evento;
    private String nombre;

    public Organizacion(Evento evento, String nombre) {
        this.evento = evento;
        this.nombre = nombre;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }



}
