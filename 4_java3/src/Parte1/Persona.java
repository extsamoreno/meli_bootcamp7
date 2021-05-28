package Parte1;

public class Persona implements IPrecedable<Persona>{

    private String name = " ";
    private int dni;

    public Persona() {
    }

    public Persona(String name, int dni) {
        this.name = name;
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }


    @Override
    public int precedeA(Persona persona) {
        return this.dni - persona.dni;
    }

    @Override
    public int precedeString(Persona persona) {
        return this.name.compareToIgnoreCase(persona.getName());
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", dni=" + dni +
                '}';
    }
}
