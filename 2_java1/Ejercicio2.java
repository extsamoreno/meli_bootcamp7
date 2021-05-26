import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese numero");
        int numero = input.nextInt();
        System.out.println("Ingrese multiplo");
        int multiplo = input.nextInt();


        for (int i = 1; i < numero+1; i++){
            if(i%multiplo == 0){
                System.out.println(i);
            }
        }
    }

}
