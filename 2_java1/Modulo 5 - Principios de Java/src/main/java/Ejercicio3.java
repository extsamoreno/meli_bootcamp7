import java.util.Scanner;

public class Ejercicio3 {

    private int numeroIngresado = 0;
    private int contadorDivisores = 1;

    public void leerDato(){
        System.out.print("Ingrese el numero que desea: ");
        Scanner lector = new Scanner(System.in);
        numeroIngresado = lector.nextInt();
    }

    public void determinarNumeroPrimo (){
        for (int i = 1; i<numeroIngresado; i++){
            if (numeroIngresado % i == 0) {
                contadorDivisores++;
            }
        }

        if (contadorDivisores > 2)
            System.out.println("El numero ingresado no es primo");
        else
            System.out.println("El numero ingresado es primo");
    }
}

/*Desarrollar un programa para informar si un número n es primo o no, siendo n un valor que el u
suario ingresará por consola.
Recordá que un número es primo cuando sólo es divisible por sí mismo y por 1.
*/