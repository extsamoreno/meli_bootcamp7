import javax.swing.*;
import java.util.Scanner;

public class nMultiplos {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.print("Ingrese n: ");
        int n= sc.nextInt();
        System.out.print("Ingrese m: ");
        int m= sc.nextInt();
        for (int i =1;i<=m*n;){
            if(i % m ==0){
                System.out.println(i);
            }
            i++;
        }
    }
}
