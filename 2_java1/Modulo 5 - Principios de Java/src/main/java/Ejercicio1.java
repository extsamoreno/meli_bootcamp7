import java.util.Scanner;

public class Ejercicio1 {

    private int cantAMostar = 0;

    public void leerDato(){
        System.out.print("Ingrese la cantidad de numeros pares que se quiere mostrar: ");
        Scanner lector = new Scanner(System.in);
        cantAMostar = lector.nextInt();
    }

    public void mostrarNumerosPares () {
        for (int i = 1; i<=cantAMostar; i++) {
            System.out.println(i*2);
        }
    }
}

/*Desarrollar un programa para mostrar los primeros n números pares, siendo n un valor que el
usuario ingresará por consola.
Recordá que un número es par cuando es divisible por 2.
*/