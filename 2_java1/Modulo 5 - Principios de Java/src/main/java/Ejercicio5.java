import java.util.Scanner;

public class Ejercicio5 {

    private int cantAMostrar = 0;
    private int cantRepeticiones = 0;
    private int digito = 0;

    public void leerDatos(){
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de numeros que desea mostrar: ");
        cantAMostrar = lector.nextInt();

        System.out.print("Ingrese el digito: ");
        digito = lector.nextInt();

        System.out.print("Ingrese la cantidad de veces que el digito debe aparecer: ");
        cantRepeticiones = lector.nextInt();
    }

    public void establecerDigitos() {
        leerDatos();
        int numerosMostrados = 0;
        int i = 0;
        while (numerosMostrados<cantAMostrar){
            int repeticionDigito = 0;
            String numeroString = Integer.toString(i);
            for (int j = 0; j < numeroString.length(); j++) {
                if (Integer.toString(digito).equals(String.valueOf(numeroString.charAt(j))))
                    repeticionDigito++;
            }
            if (repeticionDigito >= cantRepeticiones) {
                System.out.println(i);
                numerosMostrados++;
            }
            i++;
        }
    }
}

/*Desarrollar un programa para mostrar por consola los primeros n números naturales que tienen al menos m dígitos d,
siendo n, m y d valores que el usuario ingresará por consola.
Por ejemplo: si el usuario ingresa n=5, m=2 y d=3, el programa deberá mostrar por consola los primeros 5 números
naturales que tienen, al menos, 2 dígitos 3. En este caso la salida será: 33, 133, 233, 303, 313.
Según cómo decidas encarar la solución de este ejercicio, es probable que necesites utilizar recursos que aún no
hemos estudiado. El desafío consiste en googlear cómo utilizar dichos recursos y ¡utilizarlos!
*/