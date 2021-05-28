package ejercicios;

public class Persona implements Precedable<Persona> {

    private String nombre;
    private int dni;

    public Persona(String nombre, int dni) {
        this.dni=dni;
        this.nombre=nombre;
    }

    public String getNombre() { return nombre;
    }

    public void setNombre(String nombre) { this.nombre = nombre;
    }

    public int getDni() { return dni;
    }

    public void setDni(int dni) { this.dni = dni;
    }

    @Override
    public int precedeA (Persona p){

        if (this.dni<p.getDni()) return -1;
        if (this.dni>p.getDni()) return 1;
        return 0;

    }
    @Override
    public String toString() {
        return  "{ nombre : '" + this.nombre + "', dni : '" + this.dni + "' }";
    }
}
