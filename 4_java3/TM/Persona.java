public class Persona implements Precedable<Persona> {
    int dni;
    String nombre;

    public Persona(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public int precedeA(Persona persona) {
        if (this.dni > persona.getDni())
            return 1;
        else
            return 0;
    }
}
