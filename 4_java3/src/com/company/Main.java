package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Persona person3 = new Persona("Pers3", 333);
        Persona person2 = new Persona("Pers2", 122);
        Persona persona1 = new Persona("Pers1", 123);
        Persona[] aPersonas = {persona1, person2, person3};

        SortUtil.ordenar(aPersonas);

        for (int i = 0; i < aPersonas.length; i++) {
            System.out.println(aPersonas[i].getDni());
        }

        Celular celular1 = new Celular(1233, "A");
        Celular celular2 = new Celular(3333, "B");
        Celular celular3 = new Celular(2222, "C");
        Celular celular4 = new Celular(3242, "D");
        Celular[] aCelulares = {celular1, celular2, celular3, celular4};

        SortUtil.ordenar(aCelulares);
        for (int i = 0; i < aCelulares.length; i++) {
            System.out.println(aCelulares[i].getCelular());
        }
    }
}

