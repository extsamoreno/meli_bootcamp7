import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingresa un número");
        int numero = scanner.nextInt();
        boolean esPrimo = true;
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                esPrimo = false;
                break;
            }
        }
        if (esPrimo)
            System.out.print("El número es primo");
        else
            System.out.println("El número no es primo");
    }
}
