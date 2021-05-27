package com.ejercicioMañana;

public class Main {

    public static void main(String[] args) {
	    var cuenta1 = new CuentaCorriente(150);
	    var cuenta2 = new CuentaCorriente(cuenta1);
        cuenta1.transferencia(100,cuenta2);
        System.out.println(cuenta1.getSaldo());
        System.out.println(cuenta2.getSaldo());

        var contador1 = new Contador();

        var libro1 = new Libro("la casa", "456465","pedro","jose","jose");
        libro1.prestamo("agustin");
        System.out.println(libro1.toString());

    }
}
