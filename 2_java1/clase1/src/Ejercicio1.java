import java.util.Scanner;

public class Ejercicio1 {
    
    public static void resolve() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese numero");
        int input = scanner.nextInt();

        for (int i = 0; i < input; i++) {

            if(Operations.isPair(i)){
                System.out.println(i);
            }
        }



        scanner.close();
    }

 
}