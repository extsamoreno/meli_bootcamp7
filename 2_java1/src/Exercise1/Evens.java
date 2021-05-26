package Exercise1;
import java.util.Scanner;

public class Evens{
    static int[] getEvens(int n){
        int[] evens = new int[n];
        for(int i=1;i<=n;i++){
            evens[i-1] = i*2;
        }
        return evens;
    }
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        System.out.println("Escribe tu numero");
        int userRequestEvens = user.nextInt();
        int[] evens = getEvens(userRequestEvens);
        for(int number : evens){
            System.out.println(number);
        }
    }
}