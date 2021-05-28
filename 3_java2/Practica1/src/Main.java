
import java.util.Scanner;
import ejercicios.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("MENU:");
        System.out.println("Seleccione el ejercicio:");
        System.out.println("1. Cuenta Corriente.");
        System.out.println("2. Contador.");
        System.out.println("3. Libro.");
        System.out.println("4. Fracciones");
        System.out.println("5. Fecha");
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
                System.out.println("LIBRO:");
                System.out.println("Libro 1:");
                Libro l1 = new Libro();
                System.out.println(l1.toString());
                System.out.println(" ");

                System.out.println("Libro 2:");
                Libro l2 = new Libro("Harry Potter","isbn002","J. K. Rowly");
                System.out.println(l2.toString());
                System.out.println(" ");

                System.out.println("Prestamo:");
                System.out.println(l1.prestamo());
                System.out.println(" ");

                System.out.println("Devolucion:");
                System.out.println(l1.devolucion());
                System.out.println(" ");

                break;

            case 4:
                System.out.println("FRACCIONES:");
                System.out.println("Fraccion 1:");
                Fraccion f1 = new Fraccion(2,3);
                System.out.println(f1.imprimirFraccion());
                System.out.println(" ");

                System.out.println("Fraccion 2:");
                Fraccion f2 = new Fraccion(3,5);
                System.out.println(f2.imprimirFraccion());
                System.out.println(" ");

                System.out.println("Suma fracciones:");
                Fraccion f3 = f1.suma(f2);
                System.out.println(f3.imprimirFraccion());
                System.out.println(" ");

                System.out.println("Suma con entero:");
                Fraccion f4 = f1.suma(5);
                System.out.println(f4.imprimirFraccion());
                System.out.println(" ");

                System.out.println("Resta fracciones:");
                Fraccion f5 = f1.resta(f2);
                System.out.println(f5.imprimirFraccion());
                System.out.println(" ");

                System.out.println("Resta con entero:");
                Fraccion f6 = f1.resta(5);
                System.out.println(f6.imprimirFraccion());
                System.out.println(" ");

                System.out.println("Multiplicacion fracciones:");
                Fraccion f7 = f1.multiplicacion(f2);
                System.out.println(f7.imprimirFraccion());
                System.out.println(" ");

                System.out.println("Multiplicacion con entero:");
                Fraccion f8 = f1.multiplicacion(5);
                System.out.println(f8.imprimirFraccion());
                System.out.println(" ");

                System.out.println("Division fracciones:");
                Fraccion f9 = f1.division(f2);
                System.out.println(f9.imprimirFraccion());
                System.out.println(" ");

                System.out.println("Division con entero:");
                Fraccion f10 = f1.division(5);
                System.out.println(f10.imprimirFraccion());
                System.out.println(" ");
                break;

            case 5:
                System.out.println("FECHA:");
                System.out.println(" ");
                System.out.println("Fecha 1:");
                Fecha date1 = new Fecha();
                System.out.println(date1);
                System.out.println(" ");

                System.out.println("Fecha 2:");
                Fecha date2 = new Fecha(27,2,1990);
                System.out.println(date2);
                System.out.println(" ");

                break;
        }
    }

}
