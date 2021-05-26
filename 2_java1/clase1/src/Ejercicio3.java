import java.util.Scanner;
public class Ejercicio3 {
    
    public static void resolve() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese numero a examinar");
        int posiblePrime = scanner.nextInt();

        if(Operations.isPrime(posiblePrime)) {
            System.out.println("Es primo");
        }
        else{
            System.out.println("No es primo");
        }

        scanner.close();
    }


}
