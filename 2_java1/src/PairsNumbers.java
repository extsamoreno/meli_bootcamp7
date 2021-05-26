import java.util.Scanner;

public class PairsNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un numero n, para mostrar todos sus pares anteriores");
        long number = scanner.nextLong();

        for(int i = 0; i <= number; i++){
            if (i % 2 == 0){
                System.out.println(i);
            }
        }

    }
}
