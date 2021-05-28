package ejercicio1;

public class Main {
    public static void main(String[] args) {
        ejercicio1.Precedable<ejercicio1.Persona> perJoven = ejercicio1.FactoryPrecedable.generarPrecedable("Pablo", 45763283);
        ejercicio1.Precedable<ejercicio1.Persona> perVieja = ejercicio1.FactoryPrecedable.generarPrecedable("Anastacio", 20473658);
        ejercicio1.Precedable<ejercicio1.Persona> perAdulta = ejercicio1.FactoryPrecedable.generarPrecedable("Javier", 35637827);

        ejercicio1.Precedable[] precedableArrayPersona = new ejercicio1.Precedable[3];
        precedableArrayPersona[0] = perJoven;
        precedableArrayPersona[1] = perVieja;
        precedableArrayPersona[2] = perAdulta;

        ejercicio1.SortUtil.ordenar(precedableArrayPersona);

        for (ejercicio1.Precedable precedable : precedableArrayPersona) {
            System.out.println(precedable.toString());
        }

        ejercicio1.Precedable<ejercicio1.Celular> celJoven = ejercicio1.FactoryPrecedable.generarPrecedable(1783276, "Pablo");
        ejercicio1.Precedable<ejercicio1.Celular> celAdulto = ejercicio1.FactoryPrecedable.generarPrecedable(1038723, "Javier");
        ejercicio1.Precedable<ejercicio1.Celular> celViejo = ejercicio1.FactoryPrecedable.generarPrecedable(1, "Anastacio");

        ejercicio1.Precedable[] precedableArrayCelular = new ejercicio1.Precedable[3];
        precedableArrayCelular[0] = celJoven;
        precedableArrayCelular[1] = celViejo;
        precedableArrayCelular[2] = celAdulto;

        ejercicio1.SortUtil.ordenar(precedableArrayCelular);

        for (ejercicio1.Precedable precedable : precedableArrayCelular) {
            System.out.println(precedable.toString());
        }
    }
}