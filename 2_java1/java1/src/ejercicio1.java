import java.util.Scanner;

public class ejercicio1 {
    /*Desarrollar un programa para mostrar los primeros n números pares,
    siendo n un valor que el usuario ingresará por consola.
     */
    public static void mostrarPares (int n){
        int numerosParesEncontrados=0;
        int i=0;
        while(numerosParesEncontrados<n)
        {
            if(i%2==0){
                System.out.println(i+" ");
                numerosParesEncontrados++;
            }
            i++;
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribir numero: ");
        int n = scanner.nextInt();
        mostrarPares(n);

    }
}

