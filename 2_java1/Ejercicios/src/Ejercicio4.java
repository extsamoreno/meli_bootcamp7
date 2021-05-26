import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {

        int numeroIngresado = 0;
        numeroIngresado = ingresarNumero();

        mostrarNumerosPrimos(numeroIngresado);
    }

    // Scanner de ingreso de datos
    public static int ingresarNumero(){

        Scanner entrada = new Scanner(System.in);

        int numIngresado = 0;

        System.out.println("Ingrese un numero. Este sera la cantidad de numeros primos a mostrar, arrancando desde 0");
        numIngresado = entrada.nextInt();

        entrada.close();

        return numIngresado;
    }

    // Funcion que muestra los numeros primos, la cantidad a mostrar esta limitada por el usuario
    public static void mostrarNumerosPrimos(int cantidadIngresada){

        int count = 0;
        int i = 0;

        while(cantidadIngresada > count){

            if(esPrimo(i)){
                System.out.println(i);
                count++;
            }
            i++;
        }
    }

    // Funcion que responde si un numero es primo o no
    public static boolean esPrimo(int num){

        if(num == 0 || num == 1 || num == 4){
            return false;
        }

        for (int i=2 ; i < num/2 ; i++) {

            if (num % i == 0)
                return false;
        }

        return true;
    }


}
