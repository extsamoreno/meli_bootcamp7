import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Numeros Pares
public class Ejercicio1
{
    public static void main (String[] args)
    {
        System.out.println ("Por favor introduzca un numero:");
        Integer entradaTeclado = 0;
        Scanner sc = new Scanner (System.in);

        entradaTeclado = Integer.parseInt(sc.nextLine ());

        List<Integer> lst = new ArrayList<Integer>();

        for (Integer i = 0; i<entradaTeclado; i++)
        {
            if (i%2 == 0)
            {
                lst.add(i);
            }
        }

        System.out.println(lst);
    }
}
