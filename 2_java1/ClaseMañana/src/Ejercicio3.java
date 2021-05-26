import java.util.Scanner;

public class Ejercicio3 {

    public static boolean isPrime(int num){
        for(int i = 2; i < num; i++){
            if(num % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qué número quieres saber si es primo");
        int num = scanner.nextInt();

        boolean answer = isPrime(num);
        System.out.print("El número " + num + " ");
        if(answer) System.out.println("es primo");
        else System.out.println("no es primo");
    }
}
