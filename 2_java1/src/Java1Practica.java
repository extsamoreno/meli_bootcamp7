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

    public static void ejercicio3(){
        System.out.print("Enter the value of n: ");
        int n=input.nextInt();
        System.out.println(n+" is prime? "+isPrime(n));
    }

    public static void ejercicio4(){

    }

    public static boolean isPrime(int n){
        if(n<=1) return false;
        for (int i=2; i<= Math.sqrt(n); i++){
            if (n%i==0) return false;
        }
        return true;
    }
}
