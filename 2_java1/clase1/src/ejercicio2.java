import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ejercicio2 {

    //numero m y n
    {
        public static void main (String[]args)
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("Ingrese el primer número ");
            Integer numero1 = sc.nextInt();

            System.out.println("Ingrese el segundo número ");
            Integer numero2 = sc.nextInt();

            List<Integer> lst = new ArrayList<Integer>();

            for (Integer i = 0; i <= numero1; i++) {
                if (i % numero2 == 0) {
                    lst.add(i);
                }
            }

            System.out.println("los números " + lst + " son multiplos de " + numero2);
        }
    }
}