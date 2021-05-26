import java.util.Scanner;

public class Java1Practica {

    public static Scanner input= new Scanner(System.in);

    public static void main(String[] args) {

    }

    /**
     * Method that print the first n-pair numbers adding 2 to each
     * iteration
     */
    public static void ejercicio1(){
        System.out.print("Enter the value of n: ");
        int n= input.nextInt();
        int actualPairNumber=0;
        for (int i=0; i<n; i++){
            System.out.print((actualPairNumber+=2)+" ");
        }
    }

    /**
     * Method that print the first n-multiple numbers of a number m
     */
    public static void ejercicio2(){
        System.out.print("Enter the value of n: ");
        int n=input.nextInt();
        System.out.print("Enter the value of m: ");
        int m=input.nextInt();
        for (int i=1; i<=n; i++){
            System.out.print((m*i)+" ");
        }
    }

    /**
     * Method that print if the n number is prime or not
     */
    public static void ejercicio3(){
        System.out.print("Enter the value of n: ");
        int n=input.nextInt();
        System.out.println(n+" is prime? "+isPrime(n));
    }

    /**
     * Method that print the first n-prime numbers
     */
    public static void ejercicio4(){
        System.out.print("Enter the value of n: ");
        int n=input.nextInt();
        for (int i=0; i<=n; i++){
            if(isPrime(i)) System.out.print(i+" ");
        }
    }

    /**
     * Method that print the first n-natural numbers which
     * have at least m digits d
     */
    public static void ejercicio5(){
        System.out.print("Enter the value of n: ");
        int n=input.nextInt();
        System.out.print("Enter the value of m: ");
        int m=input.nextInt();
        System.out.print("Enter the value of d: ");
        int d=input.nextInt();
        int counter=1; // Controls that the corresponding n numbers are printed
        String tempInitialNumber="", tempActualNumber;
        for (int i=0; i<m; i++){
            tempInitialNumber+=d+""; // Always the first number is gonna be the number with all his digits with d
        }
        int actualNumber=Integer.parseInt(tempInitialNumber);
        while (counter<=n){
            tempActualNumber= actualNumber+""; // Force integer to string
            for (int i=0; i<m; i++){
                if(tempActualNumber.indexOf(d+"")==-1){ // If the d digit is not contained in the String that means the number is not valid
                    actualNumber++; // Proceed with the next number
                    break;
                } else {
                    tempActualNumber=tempActualNumber.replaceFirst(d+"",""); // Replace the d digit for an empty character
                    if (i==m-1) { // If is the last iteration and the previous conditions are true
                        System.out.print(actualNumber+" "); // Print the number
                        counter++; // Increase the counter
                        actualNumber++; // Proceed with the next number
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
