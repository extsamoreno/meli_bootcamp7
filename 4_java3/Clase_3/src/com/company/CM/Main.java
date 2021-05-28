package com.company.CM;

public class Main {

    public static void main(String[] args) {
        Precedable<Persona> pjoven= FactoryPrecedeable.generarPrecedeable("pablo",2);
        Precedable<Persona> pvieja= FactoryPrecedeable.generarPrecedeable("Maria",1);
        Precedable <Persona> padulta= FactoryPrecedeable.generarPrecedeable("Maria",4);
        System.out.println(pjoven.precedeA((Persona) pvieja));
        System.out.println(pvieja.precedeA((Persona) pjoven));

        Precedable[] preArray = new Precedable[3];
        preArray[0]=pjoven;
        preArray[1]=pvieja;
        preArray[2]=padulta;

        SortUtil.ordenar(preArray);

        for (Precedable pre: preArray){
            System.out.println(pre.toString());
        }


        Precedable<Celular> Celjoven= FactoryPrecedeable.generarPrecedeable(2,"Pedro");
        Precedable<Celular> Celvieja= FactoryPrecedeable.generarPrecedeable(1, "Juanita");
        Precedable <Celular> Celpadulta= FactoryPrecedeable.generarPrecedeable(7,"Ablo");

        Precedable[] preArrayCel = new Precedable[3];
        preArrayCel[0]=Celjoven;
        preArrayCel[1]=Celvieja;
        preArrayCel[2]=Celpadulta;

        SortUtil.ordenar(preArrayCel);

        for (Precedable pres: preArrayCel){
            System.out.println(pres.toString());
        }


/*
        Persona per = new Persona("luis",23242);
        System.out.println(per.getNombre());
        Persona per1 = new Persona("juan",86868);
        System.out.println(per1.getNombre());
        System.out.println("Persona segunda precede a persona uno "+per.precedeA(per1));
*/

    }
}
