package Exercise3;

import java.util.Scanner;

public class Prime {
    static boolean isPrime(int number){
        if(number<0)
            number -= number;
        if(number==2 || number==3)
            return true;
        else if((number==1) || (number%2==0) || (number%3==0))
            return false;
        int i = 5;
        while (i*i <= number)
        {
            if ((number % i)==0 || (number % (i + 2))==0)
                return false;
            i += 6;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        System.out.println("Escribe el numero");
        int number = user.nextInt();
        System.out.println(isPrime(number));
    }
}
