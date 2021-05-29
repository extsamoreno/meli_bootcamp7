import functions.Functions;

public class Ejercicio2 {
    /*
    Desarrollar un programa para mostrar los primeros n múltiplos de m,
    siendo n y m valores que el usuario ingresará por consola.
    Recordá que un número a es múltiplo de b si a es divisible por b.
    */

    public static void main(String[] args) {
        int userNumber = Functions.askNumber("Ingresa la cantidad de números a mostrar:");
        int userMult = Functions.askNumber("Ingresa el divisor de dichos números:");
        Integer[] arr = Functions.getNNumbers(userNumber, userMult);
        Functions.printArray(arr);
    }

}
