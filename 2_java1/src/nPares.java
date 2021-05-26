import javax.swing.*;
import java.util.Scanner;

public class nPares {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese n: ");
        int n = sc.nextInt();
        int i=0;
        int cont =0;
        while (i<n){
            if (cont % 2 == 0) {
                System.out.println(cont);
                i++;
            }
            cont ++;
        }
    }
}
