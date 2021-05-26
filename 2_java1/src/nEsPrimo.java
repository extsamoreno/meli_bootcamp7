import java.util.Scanner;

public class nEsPrimo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese n: ");
        int n= sc.nextInt();
        int div=0;
        for(int i=1;i<=n;i++) {
            if(n%i==0){
                div++;
            }
        }
        if(div ==1||div==2){
            System.out.print("El numero es primo");
        }
        else{
            System.out.print("El numero no es primo");
        }
    }
}
