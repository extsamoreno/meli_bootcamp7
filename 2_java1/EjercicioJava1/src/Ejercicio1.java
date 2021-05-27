import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresar cantidad de numeros pares: ");

        int cantidadVeces = sc.nextInt();

        for (int i = 0; i < cantidadVeces; i++) {
            System.out.println(i*2);
        }

    }
}
