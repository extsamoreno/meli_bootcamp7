import java.util.Scanner;
public class Ejercicio4 {
    
    public static void resolve() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese numero limite");
        int limit = scanner.nextInt();

        for (int i = 1; i < limit; i++) {

            if(Operations.isPrime(i)){
                System.out.println(i);
            }
            
        }

        scanner.close();
    }
}
