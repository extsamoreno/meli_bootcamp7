import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un numero para saber si es primo o no");
        int number = scanner.nextInt();

        if(number == 2 || number == 3){
            System.out.println("Es primo");
        }else{
            if(number % number == 0 && number % 1 == 0 && number % 2 != 0 && number % 3 != 0){
                System.out.println("Es Primo");
            }else{
                System.out.println("No es Primo");
            }
        }


    }
}
