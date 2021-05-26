import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {

        int numIngresado;
        numIngresado = ingresarNumero();

        recorrerNumeros(numIngresado);

    }

    public static int ingresarNumero(){

        Scanner entrada = new Scanner(System.in);

        int numIngresado = 0;

        System.out.println("Ingrese un numero. Se mostrara segun la cantidad ingresada, los primeros numeros pares");
        numIngresado = entrada.nextInt();

        return numIngresado;
    }

    public static void recorrerNumeros(int numIngresado){

        int count = 0;
        int numero = 0;

        while(numIngresado > count){

            if(esPar(numero)){
                System.out.println(numero);
                count++;
            }

            numero++;
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
