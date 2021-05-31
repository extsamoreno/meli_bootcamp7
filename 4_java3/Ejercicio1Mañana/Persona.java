package Ejercicio1Mañana;

public class Persona implements Precedable<Persona> {
    private String nombre;
    private long dni;

    //contructores
    public Persona(){}

    public Persona(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }


    //get and set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDni() {
        return this.dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }


    @Override
    public int precedeA(Persona t) {

        if(this.dni > t.getDni()){
            return  1;
        }

        return 0;
    }
}
