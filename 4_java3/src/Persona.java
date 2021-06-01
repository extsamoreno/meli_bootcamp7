public class Persona implements Precedable<Persona>{

    private String nombre;
    private int dni;

    public Persona() {
    }

    public Persona(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    @Override
    public int precedeAt(Persona persona) {
        int salida = 0;
        if (this.dni < persona.getDni())
            salida = -1;
        else if (this.dni > persona.getDni())
            salida = 1;
        else if (this.dni == persona.getDni())
            salida = 0;
        return salida;
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


}
