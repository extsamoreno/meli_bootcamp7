package com.company;

import com.company.ej1.CuentaCorriente;
import com.company.ej4.Fraccion;
import com.company.ej5.Fecha;

public class Main {

    public static void main(String[] args) {

        CuentaCorriente c1 = new CuentaCorriente("pepe", 1000);
        CuentaCorriente c2 = new CuentaCorriente("jorge", 1000);
        CuentaCorriente c3 = new CuentaCorriente(c2);
        CuentaCorriente c4 = new CuentaCorriente();

        c1.transferencia(c2, 500);
        System.out.println(c1.getSaldo() + " " + c2.getSaldo() + " " + c3.getSaldo() + " " + c4.getSaldo());

        c1.ingreso(1000);
        System.out.println(c1.getSaldo() + " " + c2.getSaldo() + " " + c3.getSaldo() + " " + c4.getSaldo());

        c1.egreso(1000);
        System.out.println(c1.getSaldo() + " " + c2.getSaldo() + " " + c3.getSaldo() + " " + c4.getSaldo());

        Fraccion f1 = new Fraccion(3,5);
        Fraccion f2 = new Fraccion(2,5);
        Fraccion f3;

        f3 = f1.dividir(f2);
        //f3 = f1.dividir(2);

        System.out.println(f3.getNumerador() + "/" + f3.getDenominador());

        Fecha fe1 = new Fecha();
        System.out.println(fe1.toString());

        System.out.println(Fecha.isCorrectDate(31,0,1990));
    }
}
