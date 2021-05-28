package PracticoMañana;

public class Persona implements Precedable<Persona> {
    private long dni;
    private String nombre;

    public Persona() {
        this.dni = 0;
        this.nombre = "";
    }

    public Persona(long dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    @Override
    public int precedeA(Persona persona) {
        if(this.dni > persona.getDni()){
            return 1;
        }else{
            return 0;
        }
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
