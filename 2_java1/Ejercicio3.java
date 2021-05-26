import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Numero Primo
public class Ejercicio3
{
    public static void main (String[] args)
    {
        System.out.println ("Por favor introduzca un numero:");
        Integer entradaTeclado = 0;
        Scanner sc = new Scanner (System.in);

        entradaTeclado = Integer.parseInt(sc.nextLine ());

        boolean prime = true;
        for(int i = 2; i < entradaTeclado; i++) {
            if (entradaTeclado % i == 0) {
                prime = false;
                break;
            }
        }
        if (prime)
            System.out.println (entradaTeclado + " es primo.");
        else
            System.out.println(entradaTeclado + " no es primo.");
    }
}
