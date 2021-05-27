import java.util.Scanner;

public class Ejercicio2 {

    private int cantAMostar = 0;
    private int multiplo = 0;

    public void leerDatos(){
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de numeros que se quiere mostrar: ");
        cantAMostar = lector.nextInt();

        System.out.print("Ingrese el numero multiplo: ");
        multiplo = lector.nextInt();
    }

    public void mostrarNumerosMultiplo () {
        for (int i = 1; i<=cantAMostar; i++) {
            System.out.println(i*multiplo);
        }
    }
}

/*Desarrollar un programa para mostrar los primeros n múltiplos de m, siendo n y m valores que el usuario
ingresará por consola.
Recordá que un número a es múltiplo de b si a es divisible por b.
*/