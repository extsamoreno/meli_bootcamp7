import javax.swing.*;
import java.util.Scanner;

public class nPares {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.print("Ingrese n: ");
      int n= sc.nextInt();
      for (int i =1;i<=2*n;){
          if(i % 2 ==0){
              System.out.println(i);
          }
          i++;
      }
    }
}
