import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la canitdad de valores a evaluar: ");
        int n = scanner.nextInt();

        System.out.print("Ingrese el valor con el cual se va a evaluar la multiplicidad: ");
        int m = scanner.nextInt();

        for(int i = 0 ; i<=n ; i++){
            if(i%m ==0)
                System.out.println(i);
        }

    }
}