import func.Funcs;

public class Ejercicio2 {
    /*
    Desarrollar un programa para mostrar los primeros n múltiplos de m,
    siendo n y m valores que el usuario ingresará por consola.
    Recordá que un número a es múltiplo de b si a es divisible por b.
    */

    public static void main(String[] args) {
        int userNumber = Funcs.askNumber("Ingresa la cantidad de números a mostrar:");
        int userMult = Funcs.askNumber("Ingresa el divisor de dichos números:");
        Integer[] arr = Funcs.getNNumbers(userNumber, userMult);
        Funcs.printArray(arr);
    }

}
