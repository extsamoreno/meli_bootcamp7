import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {

        boolean numPrimo;

        numPrimo = esPrimo(ingresarNumero());

        if(numPrimo == true){
            System.out.println("El numero ingresado es Primo");
        }
        else{
            System.out.println("El numero ingresado NO es Primo");
        }

    }

    // Scanner de ingreso de datos
    public static int ingresarNumero(){

        Scanner entrada = new Scanner(System.in);

        int numIngresado = 0;

        System.out.println("Ingrese un numero para averiguar si es primo o no");
        numIngresado = entrada.nextInt();

        entrada.close();

        return numIngresado;
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
