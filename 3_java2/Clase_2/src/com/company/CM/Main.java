package com.company.CM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       /* System.out.println("Ejercicio 1");
        System.out.println("Ingrese el numero de cuenta");
        String cuenta=scanner.next();
        System.out.println("Ingrese el saldo");
        String saldo=scanner.next();
        CuentaCorriente Cuenta = new CuentaCorriente(Double.parseDouble(saldo),cuenta);
        System.out.println("Cuenta "+Cuenta.getNumeroCuenta());
        System.out.println("Saldo "+Cuenta.getSaldo());
        System.out.println("se le ingresan 20 mil");
        Cuenta.ingreso(20000);
        System.out.println("Saldo "+Cuenta.getSaldo());
        System.out.println("se le restan 8 mil");
        Cuenta.egreso(8000);
        System.out.println("Saldo "+Cuenta.getSaldo());

        System.out.println("Ejercicio 2");
        Contador contador = new Contador(20);
        contador.incrementar();
        System.out.println("Incrementando "+contador.getContador());
        contador.decrementar();
        System.out.println("Decrementando "+contador.getContador());
        contador.incrementar(20);
        System.out.println("Incrementando 20 - "+contador.getContador());
        contador.decrementar(30);
        System.out.println("Decrementando 30 - "+contador.getContador());

        System.out.println("Ejercicio 3");
        Libro lib = new Libro("Harry Potter", "9780545582889", "Rowling, J. K.",true);
        System.out.println("Se pide prestado el libro y preguntamos si hay en stock");
        lib.prestamo();
        System.out.println("hay en stock "+lib.toString());
        lib.devolucion();
        System.out.println("de devuleve el libro y preguntamos si hay en stock "+lib.toString());

        System.out.println("Ejercicio 4");
        Fraccion frac1 = new Fraccion(3,4);
        Fraccion frac2 = new Fraccion(5,4);
        Fraccion.sumar(frac1,frac2);
        System.out.println("Suma "+Fraccion.sumar(frac1,frac2));
        System.out.println("resta "+Fraccion.resta(frac1,frac2));
        System.out.println("multiplicaciòn "+Fraccion.multiplicacion(frac1,frac2));
        System.out.println("Divisiòn "+Fraccion.division(frac1,frac2));
        System.out.println("Suma int"+Fraccion.sumar(1,frac2));
        System.out.println("resta int"+Fraccion.resta(frac1,1));
        System.out.println("multiplicaciòn int"+Fraccion.multiplicacion(1,frac2));
        System.out.println("Divisiòn int"+Fraccion.division(1,frac2));

        System.out.println("Ejercicio 5");
        Fecha fec= new Fecha(27,5,2021);
        System.out.println("Fecha establecida " + fec);
        System.out.println("Añadir 10 dias " + fec.addDay(10));
        System.out.println("La fecha es valida ? " +fec.isValid());
        Fecha fech= new Fecha(43,5,2021);
        System.out.println("La fecha es valida ? " +fech.isValid());*/


        System.out.println("Ejercicio 6");
        String frase="  Hola mundo  ";
        System.out.println("'"+StringUtil.rpad(frase,4,'s')+"'");
        System.out.println("'"+StringUtil.rtrim(frase)+"'");
        System.out.println("'"+StringUtil.trim(frase)+"'");
        System.out.println("'"+StringUtil.ltrim(frase)+"'");
        System.out.println("la letra se encuentra en la posicpon "+StringUtil.indexOfN(frase,'m',1)+"'");










    }


}
