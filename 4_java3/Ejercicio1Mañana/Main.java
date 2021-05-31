package Ejercicio1Mañana;

import Ejercicio1Mañana.Celular;
import Ejercicio1Mañana.Persona;

public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona("Belen", 41012558);
        Persona persona2 = new Persona("Elizabeth", 41012559);
        Persona persona3 = new Persona("Maria Rosa", 19797919);
        Persona persona4 = new Persona("José Fernando", 12548758);

        Persona[] listaPersonas = new Persona[]{persona1,persona2,persona3,persona4};

        SortUtil.ordenar(listaPersonas);

        for(int i=0 ; i<listaPersonas.length ; i++){
            System.out.println(listaPersonas[i].getDni());
        }

        Persona p = new Persona("pepe", 1);
        Persona p2 = new Persona("juana", 2);
        Celular c = new Celular(123, "juana");
        Celular c2 = new Celular(124, "Belen");


        System.out.println(p.precedeA(p2) +" " +c2.precedeA(c));



    }
}
