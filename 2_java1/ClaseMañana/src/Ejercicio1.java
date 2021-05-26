import java.util.Scanner;

public class Ejercicio1 {

    public static void show(int quantity, int multiple){
        int shows = 0;

        for(int i = multiple; shows < quantity; i++){
            if(i % multiple == 0){
                shows++;
                System.out.print(i);
                if(shows < quantity) System.out.print(", ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cuantos números pares quieres ver?");
        int quantity = scanner.nextInt();

        System.out.println("Los primeros " + quantity + " de números pares son:");
        show(quantity, 2);
    }
}
