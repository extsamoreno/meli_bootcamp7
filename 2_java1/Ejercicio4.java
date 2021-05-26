import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Numeros Primos
public class Ejercicio4
{
    public static void main (String[] args)
    {
        System.out.println ("Por favor introduzca un numero:");
        Integer entradaTeclado = 0;
        Scanner entradaEscaner = new Scanner (System.in);

        entradaTeclado = Integer.parseInt(entradaEscaner.nextLine ());

        List<Integer> lst = new ArrayList<Integer>();

        for (int j = 0; j <= entradaTeclado; j++)
        {
            boolean prime = true;

            for(int i = 2; i < j; i++) {
                if (j % i == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime)
            {
                lst.add(j);
            }
        }

        System.out.println("Todos los numeros primos hasta el " + entradaTeclado + " son " + lst);
    }
}
