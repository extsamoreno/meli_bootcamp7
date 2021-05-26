import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un numero que desea saber si es primo: ");
        int n = scanner.nextInt();
        int contador = 0;

        for(int i = 1 ; i <= n ; i++){
            if(n%i == 0)
                contador++;
        }
        if(contador == 2)
            System.out.println("El numero "+ n +" es primo.");
        else
            System.out.println("El numero "+ n +" no es primo.");

    }
}