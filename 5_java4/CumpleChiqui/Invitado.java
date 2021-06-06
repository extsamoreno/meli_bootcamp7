package CumpleChiqui;

public class Invitado {
    private String nombre;

    public Invitado() {
    }

    public Invitado(String nombre) {
        this.nombre = nombre;
    }

    public void alabar() {
        System.out.println(this.nombre);
    }

}

