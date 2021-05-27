import java.util.Scanner;

public class ejercicio3 {
    /*Desarrollar un programa para informar si un número n es primo o no, 
    siendo n un valor que el usuario ingresará por consola. 
    Recordá que un número es primo cuando sólo es divisible por sí mismo y por 1.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar numero: ");
        int numero = scanner.nextInt();
        
        if(esPrimo(numero)){
            System.out.println(numero+" es primo");
        }else{
            System.out.println(numero+" no es primo");
        }
        
    }

    public static boolean esPrimo(int numero){
        int cont = 2;
        boolean esPrimo=true;
        while ((esPrimo) && (cont!=numero)){
            if (numero % cont == 0)
                esPrimo = false;
            cont++;
        }
        return esPrimo;
    }

}
