import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {

        int numIngresado;
        numIngresado = ingresarNumero();

        mostrarNumerosPar(numIngresado);

    }

    // Scanner de ingreso de datos
    public static int ingresarNumero(){

        Scanner entrada = new Scanner(System.in);

        int numIngresado = 0;

        System.out.println("Ingrese un numero. Se mostrara segun la cantidad ingresada, los primeros numeros pares");
        numIngresado = entrada.nextInt();

        entrada.close();

        return numIngresado;
    }

    // Funcion que muestra los numeros pares, limitado por la cantidad ingresada por el usuario
    public static void mostrarNumerosPar(int numIngresado){

        int count = 0;
        int i= 0;

        while(numIngresado > count){

            if(esPar(i)){
                System.out.println(i);
                count++;
            }

            i++;
        }

    }

    // Responde si un numero es par o no
    public static boolean esPar(int num){

        if(num%2==0){
            return true;
        }
        else{
            return false;
        }
    }
}
