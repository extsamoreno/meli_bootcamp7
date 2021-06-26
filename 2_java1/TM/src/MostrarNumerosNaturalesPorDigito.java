/*Desarrollar un programa para mostrar por consola los primeros n números naturales que tienen al menos m dígitos d, siendo n, m y d valores que el usuario ingresará por consola.
        Por ejemplo: si el usuario ingresa n=5, m=2 y d=3, el programa deberá mostrar por consola los primeros 5 números naturales que tienen, al menos, 2 dígitos 3. En este caso la salida será: 33, 133, 233, 303, 313.*/


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MostrarNumerosNaturalesPorDigito {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("¿Cuántos números desea ver, comenzando desde cero?");
        int n = entrada.nextInt();

        System.out.println("¿Cuál dígito le gustaría ver en cada número que aparezca?");
        int d = entrada.nextInt();

        System.out.println("¿Cuántas veces quisiera ver ese dígito?");
        int m = entrada.nextInt();

        System.out.println(obtenerNumerosNaturales(n, m, d));
    }

    public static List<String> obtenerNumerosNaturales (int n, int m, int d) {
        List<String> numerosNaturales = new ArrayList<>();
        StringBuilder stringsNaturales = new StringBuilder(Integer.toString(d));

        stringsNaturales.append(String.valueOf(d).repeat(Math.max(0, m - 1)));

        int contador = 0;

        for (int i = 0; contador < n; i++) {
            String numeroActual = Integer.toString(i);

            if (numeroActual.contains(stringsNaturales.toString())) {
                numerosNaturales.add(numeroActual);
                contador++;
            }

        }

        return numerosNaturales;
    }
}
