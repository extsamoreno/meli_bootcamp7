import java.util.Scanner;

public class Ejercicio4 {

    private int cantAMostrar = 0;
    private int divisores = 1;


    public void leerDato(){
        System.out.print("Ingrese la cantidad de numeros primo que desea mostrar: ");
        Scanner lector = new Scanner(System.in);
        cantAMostrar = lector.nextInt();
    }

    public boolean esNumeroPrimo(int numero) {
        for (int i = 1; i<numero; i++){
            if (numero % i == 0) {
                divisores++;
            }
        }

        if (divisores > 2)
            return false;
        return true;

    }

    public void mostrarNumerosPrimo() {
        int i = 1;
        int primosEncontrados = 0;
        while (primosEncontrados<cantAMostrar) {
            if (esNumeroPrimo(i)) {
                System.out.println(i);
                primosEncontrados++;
            }
            i++;
            divisores = 1;
        }
    }
}

/*Desarrollar un programa para mostrar por consola los primeros n números primos,
siendo n un valor que el usuario ingresará por consola.
 * */
