import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Digitos
public class Ejercicio5
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el numero n: ");
        int n = sc.nextInt();

        System.out.print("Ingrese el numero m: ");
        int m = sc.nextInt();

        System.out.print("Ingrese el numero d: ");
        int d = sc.nextInt();

        int i = 0;
        int cant = 0;
        List<Integer> lst = new ArrayList<Integer>();

        do {
            int flag = cant;
            int numero = 0;
            while (flag != 0) {
                if (flag % 10 == d)
                {
                    numero++;
                }
                flag /= 10;
            }
            if (numero == 2)
            {
                lst.add(cant);
                i++;
            }
            cant++;
        } while (i < n);

        System.out.println( "Los primeros " + n + " numeros naturales " + "que tienen " + m + " digitos " + d + " son " + lst);
    }
}
