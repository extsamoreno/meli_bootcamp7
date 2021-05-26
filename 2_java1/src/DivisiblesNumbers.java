import java.util.Scanner;

public class DivisiblesNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un numero entero N, que refleja de donde empezar");
        int start = scanner.nextInt();

        System.out.println("Ingrese un numero entero M, que refleja de donde terminar");
        int finish = scanner.nextInt();

        for(int i = start; i <= finish; i++){
            if(finish % i == 0 && i != 0) {
                System.out.println(i);
            }
        }
    }
}
