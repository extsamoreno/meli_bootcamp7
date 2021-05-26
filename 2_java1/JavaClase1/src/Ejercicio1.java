import functions.Functions;

public class Ejercicio1 {
    //  Desarrollar un programa para mostrar los primeros n números pares,
    //  siendo n un valor que el usuario ingresará por consola.
    //  Recordá que un número es par cuando es divisible por 2.

    public static void main(String[] args) {
        int userNumber = Functions.askNumber("Ingresa la cantidad de número pares que deseas ver:");

        Functions.printNNumbers(userNumber, 2);
    }

}
