package JavaDay3.Ejercicio1;

public class Persona implements Precedable<Persona> {
    //Atributos
    String nombre;
    int dni;
    int edad;

    public Persona(String nombre, int dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona() {
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public int precedeA(Persona persona) {
        if(this.edad > persona.getEdad()){
            return 1;
        }
        else return 0;
    }
}
