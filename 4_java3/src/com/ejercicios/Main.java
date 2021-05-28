package com.ejercicios;

public class Main {

    public static void main(String[] args) {
        Persona[] array = new Persona[4];

        Persona pers1 = new Persona("Manuel", 40963155);
        Persona pers2 = new Persona("Ines", 41963155);
        Persona pers3 = new Persona("Santiago", 34964125);
        Persona pers4 = new Persona("Agustina", 27078803);

        array[0] = pers1;
        array[1] = pers2;
        array[2] = pers3;
        array[3] = pers4;

        SortUtil.ordenar(array);
        System.out.println("-Personas: ");

        for (int i = 0; i < array.length; i++) {
            System.out.println("Nombre: " + array[i].getNombre() + ", Dni: " + array[i].getDni());
        }

        Celular[] arrayCelulares = new Celular[4];

        Celular cel1 = new Celular("Lucas", 3512285625L);
        Celular cel2 = new Celular("Agustin", 3516572633L);
        Celular cel3 = new Celular("Antonella", 3513089045L);
        Celular cel4 = new Celular("Fatima", 3512016605L);

        arrayCelulares[0] = cel1;
        arrayCelulares[1] = cel2;
        arrayCelulares[2] = cel3;
        arrayCelulares[3] = cel4;

        SortUtil.ordenar(arrayCelulares);

        System.out.println("-Celulares: ");
        for (int i = 0; i < arrayCelulares.length; i++) {
            System.out.println("Titular: " + arrayCelulares[i].getTitular() + ", Numero: " + arrayCelulares[i].getNumero());
        }
    }
}
