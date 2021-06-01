package meli.ejerc.TercerEjercicio;

public class Invitado {
    private String nombre;
    private String apellido;
    private boolean esMeli;

    public Invitado() {
    }

    public Invitado(String nombre, String apellido, boolean esMeli) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.esMeli = esMeli;
    }

    public void gritar(){
        System.out.println("Viva la Chiqui!!");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean isEsMeli() {
        return esMeli;
    }

    public void setEsMeli(boolean esMeli) {
        this.esMeli = esMeli;
    }
}
