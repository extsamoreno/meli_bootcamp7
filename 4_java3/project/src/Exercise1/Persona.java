package Exercise1;

public class Persona implements Precedable<Persona> {
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    private String nombre;
    private int dni;

    @Override
    public int precedeA(Persona persona) {
        return this.dni - persona.getDni();
    }
}