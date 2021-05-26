import java.util.Scanner;

public class Ejercicio4 {

    public static void showPrimes(int quantity){
        int shows = 0;

        for(int i = 2; shows < quantity; i++){
            if(Ejercicio3.isPrime(i)){
                shows++;
                System.out.print(i);
                if(shows < quantity) System.out.print(", ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cuantos números primos quieres ver?");
        int quantity = scanner.nextInt();

        showPrimes(quantity);
    }
}
