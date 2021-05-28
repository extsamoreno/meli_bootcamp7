public class Persona implements Precedable<Persona> {

    public String nombre;
    public int dni;

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

    public Persona(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    @Override
    public int precedeAt(Persona persona) {
        return this.getDni()  - persona.getDni();
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", dni=" + dni +
                '}';
    }
}
