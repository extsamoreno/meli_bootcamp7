package Ex1;

public class Persona implements Precedable<Persona>{

    private String nombre;
    private int dni;

    public Persona() {
    }

    public Persona(int dni) {
        this.dni = dni;
    }

    public Persona(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

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


    @Override
    public int precedeA(Persona persona) {
        if (this.getDni() < persona.getDni())
            return 1;
        else
            return 0;
    }
}
