package com.company;

import com.company.ej1.*;

public class Main {

    public static void main(String[] args) {

        Precedable<Persona> p1 = FactoryPrecedable.generarPrecedable("pepe", 11222333);
        Precedable<Persona> p2 = FactoryPrecedable.generarPrecedable("juan", 11222334);
        Precedable<Persona> p3 = FactoryPrecedable.generarPrecedable("walter", 33222334);
        Precedable<Persona> p4 = FactoryPrecedable.generarPrecedable("luis", 1222334);

        Precedable[] arrPersona = { p1, p2, p3, p4};

        SortUtil.ordenar(arrPersona);

        for(Precedable p : arrPersona) {
            System.out.println(p.toString());
        }

        System.out.println("---------");

        Precedable<Celular> c1 = FactoryPrecedable.generarPrecedable(12344, "jorge");
        Precedable<Celular> c2 = FactoryPrecedable.generarPrecedable(1233, "pedro");
        Precedable<Celular> c3 = FactoryPrecedable.generarPrecedable(1234, "mariano");
        Precedable<Celular> c4 = FactoryPrecedable.generarPrecedable(233, "lucas");

        Precedable[] arrCelular = { c1, c2, c3, c4};

        SortUtil.ordenar(arrCelular);

        for(Precedable c : arrCelular) {
            System.out.println(c.toString());
        }

    }

}
