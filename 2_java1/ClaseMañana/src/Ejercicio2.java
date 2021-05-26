import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Los multiplos de que número quieres ver?");
        int num = scanner.nextInt();

        System.out.println("Cuantos multiplos de " + num + " quieres ver?");
        int quantity = scanner.nextInt();

        System.out.println("Los primeros " + quantity + " multiplos de " + num + " son:");
        Ejercicio1.show(quantity, num);
    }
}
