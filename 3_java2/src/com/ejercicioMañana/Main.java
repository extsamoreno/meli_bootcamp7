package com.ejercicioMañana;

public class Main {

    public static void main(String[] args) {
//	    var cuenta1 = new CuentaCorriente(150);
//	    var cuenta2 = new CuentaCorriente(cuenta1);
//        cuenta1.transferencia(100,cuenta2);
//        System.out.println(cuenta1.getSaldo());
//        System.out.println(cuenta2.getSaldo());
//
//        var contador1 = new Contador();
//
//        var libro1 = new Libro("la casa", "456465","pedro","jose","jose");
//        libro1.prestamo("agustin");
//        System.out.println(libro1.toString());
//
//        Fraccion f1 = new Fraccion(2,3);
//        Fraccion f2 = new Fraccion(8,4);
//
//        System.out.println(f1.sumar(f2));
//        System.out.println(f1.restar(f2));
//        System.out.println(f1.multiplicar(f2));
//        System.out.println(f1.dividir(f2));

        var fecha = new Fecha(22,2,1995);
        System.out.println(fecha);
        for (int i = 0; i < 30; i++) {
            fecha.sumarDia();
        }
        System.out.println(fecha);

        System.out.println(fecha.isCorrectDate(11,1,1991));
        System.out.println(fecha.isCorrectDate(33,1,1991));

        System.out.println(StringUtil.rpad("asd",5,'2'));

        System.out.println(StringUtil.ltrim("    ltrim   "));

        System.out.println(StringUtil.rtrim("    rtrim    "));
        System.out.println(StringUtil.trim("    trim    "));
        System.out.println(StringUtil.indexOfN("sdd?sdsd?sdsds?ees",'?',1));
        System.out.println(StringUtil.indexOfN("sdd?sdsd?sdsds?ees",'?',2));
        System.out.println(StringUtil.indexOfN("sdd?sdsd?sdsds?ees",'?',3));
        System.out.println(StringUtil.indexOfN("sdd?sdsd?sdsds?ees",'?',4));
    }
}
