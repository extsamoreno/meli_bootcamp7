import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {

        int num = 0;
        int cantidadMultiplos = 0;

        System.out.println("Ingrese un numero para ver sus multiplos");
        num = ingresarNumero();

        System.out.println("Ingrese la cantidad a mostrar de multiplos");
        cantidadMultiplos = ingresarNumero();

        mostrarMultiplos(num, cantidadMultiplos);

    }

    // Scanner de ingreso de datos
    public static int ingresarNumero(){

        int numIngresado = 0;

        Scanner entrada = new Scanner(System.in);
        numIngresado = entrada.nextInt();

        return numIngresado;
    }

    // Funcion que muestra los multiplos del numero ingresado. La cantidad de multiplos esta limitada por el usuario
    public static void mostrarMultiplos(int numIngresado, int cantidadIngresada){

        int count = 0;
        int i = 1;

        while(cantidadIngresada > count){

            if(numIngresado%i == 0){
                System.out.println(i);
                count++;
            }
            i++;
        }
    }
}
