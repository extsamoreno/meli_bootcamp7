import java.util.Scanner;

public class Ejercicio1 {
    
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese numero");
        int input = scanner.nextInt();

        for (int i = 0; i < input; i++) {

            if(i%2 == 0){
                System.out.println(i);
            }
        }



        scanner.close();
    }
}
