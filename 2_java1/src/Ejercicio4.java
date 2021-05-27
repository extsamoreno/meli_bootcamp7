import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingresa un número");
        int numero = scanner.nextInt();
        int m = 2, i = 0;
        boolean esPrimo = true;
        while (i < numero) {
            for (int j = 2; j < m; j++) {
                if (m % j == 0 & m !=2) {
                    esPrimo = false;
                    break;
                }
            }
            if (esPrimo) {
                System.out.print(m + " ");
                i++;
            }
            esPrimo=true;
            m++;

        }

    }
}
