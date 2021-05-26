import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el valor de los primero n valores que desea saber si son primos: ");
        int n = scanner.nextInt();

        for(int i = 0 ; i <= n ; i++){ //itero entre todos los numeros que el usuario quiere

            int contador = 0;
            for(int j = 1 ; j <= n ; j++) { //cuento cuantos divisores tiene
                if (i % j == 0)
                    contador++;
            }
            if(contador == 2) {
                System.out.println("El numero " + i + " es primo.");
            }
        }

    }
}