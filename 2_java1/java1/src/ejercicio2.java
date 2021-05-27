import java.util.Scanner;

public class ejercicio2 {
/*Desarrollar un programa para mostrar los primeros n múltiplos de m,
siendo n y m valores que el usuario ingresará por consola.
Recordá que un número a es múltiplo de b si a es divisible por b.
 */

    public static void mostrarMultiplos(int numero, int cantMultiplos){
        int cantMultiplosEncontrados=0, i=1;
        while(cantMultiplosEncontrados<cantMultiplos){
            if(numero%i==0){
                System.out.println(i);
                cantMultiplosEncontrados++;
            }
            i++;
        }
    }


    public static void main(String[] args) {
        int cantMultiplos,numero;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar numero: ");
        numero = scanner.nextInt();

        System.out.println("Ingresar cant de multiplos: ");
        cantMultiplos = scanner.nextInt();

        mostrarMultiplos(numero,cantMultiplos);

    }


}
