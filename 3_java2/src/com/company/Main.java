package com.company;

import com.company.ej1.CuentaCorriente;
import com.company.ej4.Fraccion;
import com.company.ej5.Fecha;
import com.company.ej6.StringUtil;

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
        Fraccion f2 = new Fraccion(7,5);
        Fraccion f3;

        //f3 = f1.dividir(f2);
        f3 = f1.dividir(3);

        System.out.println(f3);

        Fecha fe1 = new Fecha(31, 12, 2021);
        System.out.println(fe1);

        System.out.println(Fecha.isCorrectDate(29,2,2020));

        fe1.addDays(1);
        System.out.println(fe1);

        String s1 = "   1   ";
        String s2 = "111222333";

        System.out.println(StringUtil.rpad("111", '0', 5));
        System.out.println("     '" + s1 + "'");
        System.out.println(" trim'" + StringUtil.trim(s1) + "'");
        System.out.println("ltrim'" + StringUtil.ltrim(s1) + "'");
        System.out.println("rtrim'" + StringUtil.rtrim(s1) + "'");
        System.out.println(StringUtil.indexOfN(s2, '3', 1));
    }
}
