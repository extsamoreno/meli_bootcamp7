import java.util.Scanner;

public class DivisiblesNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un numero entero N, que refleja la cantidad de numeros a visualizar");
        int quantity = scanner.nextInt();

        System.out.println("Ingrese un numero entero M, que refleja el numero con el cual tienen que ser Divisible");
        int divisibleNumber = scanner.nextInt();

        for(int i = 0; i <= quantity; i++){
            if(i != 0 && divisibleNumber % i == 0) {
                System.out.println(i);
            }
        }
    }
}
