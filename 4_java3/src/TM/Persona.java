package TM;

public class Persona<t> implements Precedable<Persona>{
    private String nombre;
    private long dni;

    public Persona(){}

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

    public void setDni(int dni) {
        this.dni = dni;
    }

    public long getDni() {
        return dni;
    }

    // Recibe un generic y casteo luego dentro de precedeA
    @Override
    public int precedeA(Persona t) {
        if(this.dni > t.getDni())
            return 1;
        return 0;
    }
}
