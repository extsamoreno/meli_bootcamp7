
import java.util.Scanner;
import ejercicios.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("MENU:");
        System.out.println("Seleccione el ejercicio:");
        System.out.println("1. Cuenta Corriente.");
        System.out.println("2. Contador.");
        System.out.println("3. Número primo.");
        System.out.println("4. Números primos menores a n.");
        System.out.println("5. .");
        System.out.println(" ");
        int menu = scanner.nextInt();
        System.out.println(" ");

        switch (menu){
            case 1:
                System.out.println("CUENTA CORRIENTE");

                System.out.println("Cuenta Corriente 1:");
                CuentaCorriente cc1 = new CuentaCorriente();
                System.out.println("Titular: " + cc1.getTitular() + ", Saldo: " + cc1.getSaldo());
                System.out.println(cc1.toString());

                System.out.println("Cuenta Corriente 2:");
                CuentaCorriente cc2 = new CuentaCorriente("Yofo", 2000);
                System.out.println("Titular: " + cc2.getTitular() + ", Saldo: " + cc2.getSaldo());
                System.out.println(cc2.toString());

                System.out.println("Cuenta Corriente 3:");
                CuentaCorriente cc3 = new CuentaCorriente(cc1);
                System.out.println(cc3.toString());

                System.out.println("Ingreso de 1000:");
                cc1.ingreso(1000);
                System.out.println(cc1.getSaldo());

                System.out.println("Egreso de 500:");
                cc1.egreso(500);
                System.out.println(cc1.getSaldo());

                System.out.println("Transferecia a cc2:");
                cc1.transferencia(cc2,150);
                System.out.println("Saldo cc1: "+cc1.getSaldo());
                System.out.println("Saldo cc2: "+cc2.getSaldo());
                System.out.println(cc1.imprimirTransferencia(cc1.transferencia(cc2,150)));


                System.out.println(" ");
                break;

            case 2:
                System.out.println("CONTADOR:");
                System.out.println("Contador 1:");
                Contador c1 = new Contador();
                System.out.println(c1.getValor());

                System.out.println("Contador 2:");
                Contador c2 = new Contador(10);
                System.out.println(c2.getValor());

                System.out.println("Contador 3:");
                Contador c3 = new Contador(c1);
                System.out.println(c3.getValor());

                System.out.println("Incrementar c2:");
                c2.incrementar();
                System.out.println(c2.getValor());

                System.out.println("decrementar c2:");
                c2.decrementar();
                System.out.println(c2.getValor());

                System.out.println(" ");
                break;

            case 3:
                /**
                System.out.println("n ES NÚMERO PRIMO?:");
                System.out.println("Ingresa el valor de n:");
                n = scanner.nextInt();
                boolean primo = Ejercicio3.es_primo(n);
                System.out.print(primo?"Es primo":"NO es primo");
                System.out.println(" ");
                 **/
                break;

            case 4:
                /**
                System.out.println("NÚMEROS PRIMOS MENORES A n:");
                System.out.println("Ingresa el valor de n:");
                n = scanner.nextInt();
                Ejercicio4.primosMenores(n);
                System.out.println(" ");
                 **/
                break;

            case 5:

        }
    }

}
