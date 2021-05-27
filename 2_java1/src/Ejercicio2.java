import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingresa un número");
        int m = scanner.nextInt();
        System.out.println("Por favor ingresa el número de múltiplos que quieres ver");
        int n = scanner.nextInt();
        int k=1;
        for (int i=0;i<n;i++) {
            System.out.print(m*k + " " );
            k++;
        }
    }

}
