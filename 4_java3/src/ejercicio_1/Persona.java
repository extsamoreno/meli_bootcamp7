package ejercicio_1;

public class Persona implements Precedable<Persona> {
    private String nombre;
    private int dni;

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

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public int precedeA(Persona persona) {
        if (this.dni < persona.dni) {
            return 1;
        }
        else
            return 0;
    }
    /* Respuesta ejercicio 2: Para cambiar el criterio de precedencia se cambia el atributo que se está comparando
    sin importar el tipo de dato que éste sea
    la propuesta en mi opinión no es tan fácil de mantener a lo largo del tiempo porque por cada clase que se cree es necesario detallar el método
    sin importar que el método se implemente de la misma forma que en otra clase
    Se podría mejorar añadiendo otro parametro por el cual se le pase o indique el atributo por el cual se desea ordenar
     */
}
