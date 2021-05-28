package com.bootcamp;

public class Main {

    public static void main(String[] args) {

        //Probando suma de fracciones
        Fraccion fr1 = new Fraccion(7, 5);
        Fraccion fr2 = new Fraccion(5, 3);
        fr1.sumar(fr2);
        System.out.println(fr1);

        //Probando suma de una fracción con un entero
        Fraccion fr3 = new Fraccion(2, 3);
        fr3.sumar(10);
        System.out.println(fr3);

        //Probando resta de fracciones
        Fraccion fr4 = new Fraccion(8, 5);
        Fraccion fr5 = new Fraccion(21, 7);
        fr4.restar(fr5);
        System.out.println(fr4);

        //Probando resta de una fracción con un entero
        Fraccion fr6 = new Fraccion(10, 3);
        fr6.restar(8);
        System.out.println(fr6);

        //Probando multiplicación de fracciones
        Fraccion fr7 = new Fraccion(8, 5);
        Fraccion fr8 = new Fraccion(2, 10);
        fr7.multiplicar(fr8);
        System.out.println(fr7);

        //Probando división de fracciones
        Fraccion fr9 = new Fraccion(8, 5);
        Fraccion fr10 = new Fraccion(2, 10);
        fr9.dividir(fr10);
        System.out.println(fr9);


        //Probando fechas
        Fecha fec = new Fecha(9, 9, 1996);
        System.out.println(fec);
        fec.nextDay();
        System.out.println(fec);

        //Chequeando validez
        Fecha fec2 = new Fecha(100, 1, 1990);
        System.out.println(fec2.isCorrect());

        //Pruebas strings
        System.out.println(StringUtil.rtrim("   Hola     ").concat("mundo"));
        System.out.println(StringUtil.ltrim("   Hola mundo"));
        System.out.println(StringUtil.trim("  Buenas  ").concat("tardes"));
        System.out.println(StringUtil.rpad("109", '0', 8));
        System.out.println(StringUtil.indexOfN("elefante", 'e', 2));

    }
}
