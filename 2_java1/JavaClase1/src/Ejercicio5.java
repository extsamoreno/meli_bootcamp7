import functions.Functions;

public class Ejercicio5 {

    /*Desarrollar un programa para mostrar por consola los primeros n números naturales
    que tienen al menos m dígitos d, siendo n, m y d valores que el usuario ingresará por consola.
    Por ejemplo: si el usuario ingresa n=5, m=2 y d=3, el programa deberá mostrar por consola
    los primeros 5 números naturales que tienen, al menos, 2 dígitos 3.
    En este caso la salida será: 33, 133, 233, 303, 313.
    Según cómo decidas encarar la solución de este ejercicio, es probable que necesites
    utilizar recursos que aún no hemos estudiado. El desafío consiste en googlear cómo utilizar dichos recursos
    y ¡utilizarlos!*/

    // n cant num, m cant digitos, d digito que debe repetirse m veces.

    int n = Functions.askNumber("Ingrese la cantidad de números a mostrar: ");
    int m = Functions.askNumber("Ingrese el dígito que busca: ");
    int d = Functions.askNumber("Ingrese la cantidad de repeticiones del dígito: ");



}
