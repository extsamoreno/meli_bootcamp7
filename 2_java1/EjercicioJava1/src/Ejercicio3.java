import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Numero al que se quiere saber si es primo: ");
        int primo = sc.nextInt();

        boolean esPrimo = false;

        for (int i = 2; i < primo; i++) {
            double resultado = (double)primo%i;
            if(resultado == 00.0){
                esPrimo = true;
            }
        }

        if (esPrimo == true){
            System.out.println("No es primo");
        }else{
            System.out.println("Es primo");
        }
    }
}
