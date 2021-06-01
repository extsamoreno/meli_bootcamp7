import java.util.Scanner;

public class Ejercicio4 {

    public static boolean esPrimo(int primo) {
        boolean esPrimo = true;
        for (int i = 2; i < primo; i++) {
            double resultado = (double) primo % i;
            if (resultado == 00.0) {
                esPrimo = false;
            }
        }

        return esPrimo;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Cantidad de numeros primos: ");
        int cantidadPrimo = sc.nextInt();
        int recorredor = 2;

        for (int i = 0; i < cantidadPrimo; ) {

            if (esPrimo(recorredor)){
                System.out.println(recorredor);
                i++;
            }
            recorredor++;

        }

    }

}