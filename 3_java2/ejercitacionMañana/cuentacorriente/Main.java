package cuentacorriente;

public class Main {
    public static void main(String[] args) {
        CuentaCorriente cc1 = new CuentaCorriente();
        CuentaCorriente cc2 = new CuentaCorriente("234", 0);
        CuentaCorriente cc3 = new CuentaCorriente("345", cc1.getSaldo());

        cc1.setNro("123");
        cc1.setSaldo(100.45);

        System.out.println("El número de cuenta es: " + cc1.getNro() +
                " y su saldo es: " + cc1.getSaldo());

        System.out.println("El número de cuenta es: " + cc2.getNro() +
                " y su saldo es: " + cc2.getSaldo());

        cc1.ingreso(50);
        System.out.println("Su cuenta es: " + cc1.getNro() +
                "Su saldo es: " + cc1.getSaldo());
        cc1.egreso(25.45);
        System.out.println("Su cuenta es: " + cc1.getNro() +
                " Su saldo es: " + cc1.getSaldo());

        System.out.println("El número de cuenta es: " + cc3.getNro() +
                " y su saldo es: " + cc3.getSaldo());

        cc1.reintegro(50);
        cc1.transferencia(cc3,50);

        System.out.println("Su cuenta es: " + cc1.getNro() +
                " Su saldo es: " + cc1.getSaldo());

        System.out.println("El número de cuenta es: " + cc3.getNro() +
                " y su saldo es: " + cc3.getSaldo());
    }
}
