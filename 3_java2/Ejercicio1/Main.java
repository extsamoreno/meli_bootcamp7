package Ejercicio1;

public class Main {
    //Pruebas ejercicio 1
    public static void main(String[] args) {
        CuentaCorriente cuenta1= new CuentaCorriente("0001", 3000);
        CuentaCorriente cuenta2 = new CuentaCorriente();
        CuentaCorriente cuenta3 = new CuentaCorriente(cuenta1);
        System.out.println(cuenta1.toString());
        System.out.println(cuenta2.toString());
        System.out.println(cuenta3.toString());



        CuentaCorriente.transferencia(150.0,cuenta1,cuenta2);
        System.out.println(cuenta1.toString());
        System.out.println(cuenta2.toString());

        cuenta2.ingreso(450.3);
        System.out.println(cuenta2.toString());

        cuenta3.egreso(23.5);
        System.out.println(cuenta3.toString());
    }
}
