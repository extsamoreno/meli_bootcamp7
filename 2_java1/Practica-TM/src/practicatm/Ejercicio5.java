package practicatm;

import java.util.Scanner;

public class Ejercicio5 {

    static char[] spliter (int numero){
        String numeroString = String.valueOf(numero);
        char[] digitos = numeroString.toCharArray();
        return digitos;
    }

    static boolean verificador (char[] digitos, int m ,int d ){
        int logitud = digitos.length;
        int contador = 0;
        for (int i=0; i<logitud ; i++) {

            if ((Character.getNumericValue(digitos[i]))==m){
                contador++;
            }
        }
        if (contador==d){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese n: ");
        int n= input.nextInt();
        System.out.print("Ingrese m: ");
        int m= input.nextInt();
        System.out.print("Ingrese d: ");
        int d= input.nextInt();
        int cantidad = 0;
        int numero = 0;

        while (cantidad<=n){
            if (verificador(spliter(numero),m,d)){
                System.out.println(numero);
                cantidad++;
            }
            numero ++;
        }
    }
}
