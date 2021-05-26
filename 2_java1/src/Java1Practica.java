import java.util.Scanner;

public class Java1Practica {

    public static Scanner input= new Scanner(System.in);

    public static void main(String[] args) {
        
    }

    public static void ejercicio1(){
        System.out.print("Enter the value of n: ");
        int n= input.nextInt();
        int actualPairNumber=0;
        for (int i=0; i<n; i++){
            System.out.print((actualPairNumber+=2)+" ");
        }
    }

    public static void ejercicio2(){
        System.out.print("Enter the value of n: ");
        int n=input.nextInt();
        System.out.print("Enter the value of m: ");
        int m=input.nextInt();
        for (int i=1; i<=n; i++){
            System.out.print((m*i)+" ");
        }
    }
}
