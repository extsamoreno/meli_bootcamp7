package Ejercicio1;

public class Persona implements Precedeable<Persona>{
    private String name;
    private int dni;

    public Persona(String name, int dni)
    {
        this.setName(name);
        this.setDni(dni);

    }


    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setDni(int dni)
    {
        this.dni = dni;
    }

    public int getDni()
    {
        return dni;
    }

    @Override
    public int precedeA(Persona t) {
        if (this.getDni() < t.getDni())
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    @Override
    public String toString() {
        String repr = "Número DNI: " + this.getDni() + ", Nombre: " + this.getName();
        return repr;
    }
}
