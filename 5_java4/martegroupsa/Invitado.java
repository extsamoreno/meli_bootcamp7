package martegroupsa;

public class Invitado {
    String nombre;

    public Invitado() {
    }

    public Invitado(String nombre) {
        this.nombre = nombre;
    }

    public void comerTorta(){
        System.out.println("El invitado " + this.nombre + " está comiendo torta");
    }
}