import java.util.Scanner;

public class N_PrimesNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un N para imprimir los numeros primos que lo preceden");
        int number = scanner.nextInt();

        for(int i = 1; i < number; i++){
            if(i == 2 || i == 3){
                System.out.println(i + "- Es primo");
            }else{
                if(i % i == 0 && i % 1 == 0 && i % 2 != 0 && i % 3 != 0){
                    System.out.println(i + "- Es Primo");
                }else{
                    System.out.println(i + "- No es Primo");
                }
            }
        }

    }
}
