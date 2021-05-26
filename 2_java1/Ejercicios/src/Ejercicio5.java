import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {

        int cantNumNaturales = 0;
        int cantDigitos = 0;
        int digito = 0;

        System.out.println("Ingrese un numero que representa la cantidad de numeros naturales a mostrar");
        cantNumNaturales = ingresarNumero();

        System.out.println("Ingrese la cantidad de digitos minima que debe tener cada numero");
        cantDigitos = ingresarNumero();

        System.out.println("Ingrese el digito que desea buscar");
        digito = ingresarNumero();

        mostrarNumerosNaturales(cantNumNaturales, cantDigitos, digito);
    }

    // Scanner de ingreso de datos
    public static int ingresarNumero(){

        int numIngresado = 0;

        Scanner entrada = new Scanner(System.in);
        numIngresado = entrada.nextInt();

        return numIngresado;
    }

    // Muestra los numeros naturales que cumplan con las condiciones ingresadas por el usuario
    public static void mostrarNumerosNaturales(int cantNum, int cantDigitos, int digito){

        int count = 0;
        int i = 0;

        while(cantNum > count){

            if(contarDigito(i, digito) >= cantDigitos){
                System.out.println(i);
                count++;
            }
            i++;
        }
    }

    // Cuenta la cantidad de veces que se repite un digito del numero ingresado
    public static int contarDigito(int num, int digitoBuscado) {

        int count = 0;
        String numStr = Integer.toString(num);

        for (int i = 0; i < numStr.length(); i++) {

            int numDigito = Character.getNumericValue(numStr.charAt(i)); // voy tomando cada caracter del numero

            if (numDigito == digitoBuscado) {
                count++;
            }
        }

        return count;
    }
}
