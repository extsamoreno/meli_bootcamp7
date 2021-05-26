import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el valor de los primeros numeros pares que desea ver: ");
        int n = scanner.nextInt();

        for(int i=0 ; i <= n ; i++){
            if(i%2 ==0)
                System.out.println(i);

        }
    }

}