import static func.Funcs.*;

public class Ejercicio5 {

    /*Desarrollar un programa para mostrar por consola los primeros n números naturales
    que tienen al menos m dígitos d, siendo n, m y d valores que el usuario ingresará por consola.
    Por ejemplo: si el usuario ingresa n=5, m=2 y d=3, el programa deberá mostrar por consola
    los primeros 5 números naturales que tienen, al menos, 2 dígitos 3.
    En este caso la salida será: 33, 133, 233, 303, 313.
    Según cómo decidas encarar la solución de este ejercicio, es probable que necesites
    utilizar recursos que aún no hemos estudiado. El desafío consiste en googlear cómo utilizar dichos recursos
    y ¡utilizarlos!*/

    public static void main(String[] args) {


        int n = askNumber("Ingrese la cantidad de números a mostrar:\n>>>");
        int m = askNumber("Ingrese la cantidad de repeticiones del dígito que busca:\n>>>");
        int d = askNumber("Ingrese el dígito buscado:\n>>>");

        int i = 0;
        int cont = 0;
        while (cont < n) {
            if (cumpleCondicion(i, m, d)) {
                cont++;
                System.out.println(i);
            }

            i++;
        }
    }

}
