package com.ejercicioMañana;
//1. Crear la interface Precedable<T> con un método public int precedeA(T t).
//2. Crear la clase Persona, con los atributos String nombre, e int dni, sus métodos de acceso y los constructores que consideres adecuados.
//3. Hacer que Persona implemente Precedable<Persona>, luego sobreescribir el método int precedeA(Persona t).
//4. Establecer un criterio de precedencia para implementar el método anterior. Podría ser que una persona precede a otra si su DNI es menor, o su nombre es alfabéticamente menor, etcétera.
//5. Crear la clase SortUtil con el método public static <T> ordenar(Precedable<T> arr[]).
//
//6. Dentro del método anterior desarrollar el algoritmo de la burbuja para ordenar el array.
//7. Discusión: El método ordenar, ¿puede ordenar un array de cualquier tipo de dato? 8. Crear un programa, declarar un array con varias personas, ordenarlo y mostrarlo.
//9. Crear la clase Celular, con los atributos: numero y titular, implementar
//Precedable<Celular> y proceder del mismo modo que lo hicimos con Persona a partir del punto anterior.
public class Main {

    public static void main(String[] args) {
        Persona[] personas = new Persona[3];
        personas[0] = new  Persona("juan", 123);
        personas[1] = new Persona("pepe", 223);
        personas[2] = new Persona("martin", 100);

        //Integer[] number = new Integer[3];

        SortUtil.ordenar(personas);
        for (Persona per: personas
             ) {
            System.out.println(per);
        }

        Celular[] celulares = new Celular[3];
        celulares[0] = new  Celular("juan", 946213);
        celulares[1] = new Celular("pepe", 846464);
        celulares[2] = new Celular("martin", 1231);

        //Integer[] number = new Integer[3];

        SortUtil.ordenar(celulares);
        for (Celular cel: celulares
        ) {
            System.out.println(cel);
        }


    }
}
