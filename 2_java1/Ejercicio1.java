import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese numero");
        int numero = input.nextInt();

        for (int i = 1; i < numero+1; i++){
            if(i%2 == 0){
                System.out.println(i);
            }
        }
    }

}
