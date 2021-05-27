import java.util.Scanner;

public class ejercicio5 {
    /*Desarrollar un programa para mostrar por consola los primeros n números naturales que
    tienen al menos m dígitos d, siendo n, m y d valores que el usuario ingresará por consola.
     */

    public static void main(String[] args) {
        int cantMinNum,cantNumMostrar, numero;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar cantidad numeros a mostrar: "); //n
        cantNumMostrar = scanner.nextInt();

        System.out.println("Ingresar cant minimo de numeros: "); //m
        cantMinNum = scanner.nextInt();

        System.out.println("Ingresar numero requerido: "); //d
        numero = scanner.nextInt();
    }

 /*   public static void mostrarNumerosEnteros(int cantMinNum, int cantNumMostrar,int numero){
        int cont = 0;
        int i = 0;
        while(cont != cantNumMostrar){
            contieneNumero(numero,cantMinNum);
            cont++;
            i++;
        }
    }*/

}
