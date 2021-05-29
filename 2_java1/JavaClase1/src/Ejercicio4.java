import functions.Functions;

public class Ejercicio4 {

    /*
    Desarrollar un programa para mostrar por consola los primeros n números primos,
    siendo n un valor que el usuario ingresará por consola.
    */

    public static void main(String[] args) {

        int userNumber = Functions.askNumber("Ingresa la cantidad de números primos a mostrar:");
        Functions.printArray(Functions.getNPrimeNums(userNumber));
    }

}
