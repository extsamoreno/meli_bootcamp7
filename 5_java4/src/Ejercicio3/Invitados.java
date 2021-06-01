package Ejercicio3;

public abstract class Invitados {
    protected String nombre, apellido;
    protected int dni;

    public Invitados(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    public void comerTorta(){
        System.out.println("Comiendo torta, yummy");
    }
}
//lista de invitados meli clase que heredan de invitados
//lista de invitados standar clase que heredan de invitados
//lista de fuegos artificiales individuales heredan de fuegos artificiales
//lista de packs fuegos artificiales heredan de fuegos artificiales



