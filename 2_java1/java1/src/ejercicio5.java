import java.util.Scanner;

public class ejercicio5 {
    /*Desarrollar un programa para mostrar por consola los primeros n números naturales que
    tienen al menos m dígitos d, siendo n, m y d valores que el usuario ingresará por consola.
     */

    public static void main(String[] args) {
        int n,m, d;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar cantidad numeros a mostrar: "); //n
        n = scanner.nextInt();

        System.out.println("Ingresar cant minimo de numeros: "); //m
        m = scanner.nextInt();

        System.out.println("Ingresar numero requerido: "); //d
        d = scanner.nextInt();

        mostrarNumerosEnteros(n,m,d);
    }

   public static void mostrarNumerosEnteros( int n,int m,int d) {
       int totalNum = 0, countm = 0, i = 1, num = 1;
       while (totalNum != n) {
           num = i;
           while (num != 0) {
               if (num % 10 == d) countm++;
               num = num / 10;
           }
           if (countm >= m) {
               System.out.println(i);
               totalNum++;
           }
           countm = 0;
           i++;
       }
   }
}
