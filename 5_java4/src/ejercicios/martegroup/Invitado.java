package ejercicios.martegroup;

public abstract class Invitado {
    private  String nombre, apellido;
    private Integer dni;

    public Invitado(String nombre, String apellido, Integer dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
}
