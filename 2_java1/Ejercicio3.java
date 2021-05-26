import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese numero");
        int numero = input.nextInt();

          if(esPrimo(numero)){
              System.out.println(numero + " Es primo");
          }else{
              System.out.println(numero + " No es primo");
          }
    }

    public static boolean esPrimo(int numero) {

        if (numero <= 1) {
            return false;
        }

        int contador = 0;

        for (int i = (int) Math.sqrt(numero); i > 1; i--) {
            if (numero % i == 0) {
                contador++;
            }
        }

        return contador < 1;
    }

}