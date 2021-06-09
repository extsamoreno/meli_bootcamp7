package com.company;


public class Main {

    public static void main(String[] args) {
        CuentaCorriente cc1 = new CuentaCorriente();
        CuentaCorriente cc2 = new CuentaCorriente();
        CuentaCorriente cc3 = new CuentaCorriente();

        cc1.setNumeroCuenta("1");
        cc1.setSaldo(100);
        System.out.println("La cuenta Nª " + cc1.getNumeroCuenta() + " tiene un saldo de: " + cc1.getSaldo());

        cc2.setNumeroCuenta("2");
        cc2.setSaldo(97.50);
        System.out.println("La cuenta Nª " + cc2.getNumeroCuenta() + " tiene un saldo de: " + cc2.getSaldo());

        cc3.setNumeroCuenta("3");
        cc3.setSaldo(10.20);
        System.out.println("La cuenta Nª " + cc3.getNumeroCuenta() + " tiene un saldo de: " + cc3.getSaldo());

        cc1.egreso(50);
        System.out.println("La cuenta Nª " + cc1.getNumeroCuenta() + " tiene un saldo de: " + cc1.getSaldo());

        cc2.ingreso(100);
        System.out.println("La cuenta Nª " + cc2.getNumeroCuenta() + " tiene un saldo de: " + cc2.getSaldo());

        cc3.transferencia(cc1,5);
        System.out.println("La cuenta Nª " + cc3.getNumeroCuenta() + " tiene un saldo de: " + cc3.getSaldo());
        System.out.println("La cuenta Nª " + cc1.getNumeroCuenta() + " tiene un saldo de: " + cc1.getSaldo());
    }
}
