import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese numeros");
        int numeros = scanner.nextInt();
        System.out.println("Ingrese digitos");
        int digitos = scanner.nextInt();
        System.out.println("Ingrese digito");
        int digito = scanner.nextInt();

        if(digitos < 2){
            for (int i = 0; i < numeros +1; i++) {
                if(i == digito){
                    System.out.println(i);
                }
            }
        }else{

            int contador = 0;
            for (int i = 10;; ) {
                if(contarDigitos(i,digitos,digito)){
                    System.out.println(i);
                    contador++;
                    if(contador == numeros){
                        break;
                    }
                }
                i++;
            }
        }


    }

    public static boolean contarDigitos(int numero , int digitos , int digito){
        int contador = 0;

        while(numero!=0){
            if(numero/10==digito){
                contador++;
            }
            numero/=10;
        }
        return contador==digitos;
    }

}
