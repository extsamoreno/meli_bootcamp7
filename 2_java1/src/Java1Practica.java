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
        System.out.print("Enter the value of n: ");
        int n=input.nextInt();
        for (int i=0; i<=n; i++){
            if(isPrime(i)) System.out.print(i+" ");
        }
    }

    public static void ejercicio5(){
        System.out.print("Enter the value of n: ");
        int n=input.nextInt();
        System.out.print("Enter the value of m: ");
        int m=input.nextInt();
        System.out.print("Enter the value of d: ");
        int d=input.nextInt();
        int counter=1;
        String tempInitialNumber="", tempActualNumber;
        for (int i=0; i<m; i++){
            tempInitialNumber+=d+"";
        }
        int actualNumber=Integer.parseInt(tempInitialNumber);
        while (counter<=n){
            tempActualNumber= actualNumber+"";
            for (int i=0; i<m; i++){
                if(tempActualNumber.indexOf(d+"")==-1){
                    actualNumber++;
                    break;
                } else {
                    tempActualNumber=tempActualNumber.replaceFirst(d+"","");
                    if (i==m-1) {
                        System.out.print(actualNumber+" ");
                        counter++;
                        actualNumber++;
                    }
                }
            }
        }
    }

    /**
     * This method checks whether a number is prime or not by
     * looking for the divisibility of all numbers between 2
     * and sqrt (n). The justification for sqrt (n) is here:
     * https://www.wikiprimes.com/como-saber-si-un-numero-es-primo/
     * @param n -> The number to be analyzed
     * @return True if its prime, false if isn´t
     */
    public static boolean isPrime(int n){
        if(n<=1) return false;
        for (int i=2; i<= Math.sqrt(n); i++){
            if (n%i==0) return false;
        }
        return true;
    }
}
