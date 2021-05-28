public class Persona implements Precedable<Persona>{

    private String nombre;
    private int dni;
    private int edad;
    
    public Persona(String nombre, int dni, int edad){

        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;

    }



    public int precedeA(Persona persona){
        
        return (this.edad < persona.getEdad()) ? 1 : 0;
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

}
