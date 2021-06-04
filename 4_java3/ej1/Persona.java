package ejercitacionMañana.ej1;

public class Persona implements Precedable<Persona> {

    String nombre;
    int dni;

    public Persona() {
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


    @Override
    public int precedeA(Persona persona) {
        if (this.dni > persona.getDni())
            return 1;
        else
            return 0;
    }

}
