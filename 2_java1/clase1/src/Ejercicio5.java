import java.util.Scanner;
public class Ejercicio5 {
    
    public static void resolve() throws Exception {

        int counter = 0;
        int iterator = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese numero n");
        int n = scanner.nextInt();

        System.out.println("Ingrese numero m");
        int m = scanner.nextInt();

        System.out.println("Ingrese numero d");
        int d = scanner.nextInt();


        while(counter < n){
            
            if(Operations.isContainedManyTimes(iterator, d, m)){
                System.out.println(iterator);
                counter++;
            }

            iterator++;

        }

        scanner.close();
    }
}
