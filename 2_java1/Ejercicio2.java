import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Numero Multiplo
public class Ejercicio2
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner (System.in);

        System.out.println ("Por favor ingrese el primer numero ");
        Integer numero1 = sc.nextInt();

        System.out.println ("Por favor ingrese el segundo numero ");
        Integer numero2 = sc.nextInt();

        List<Integer> lst = new ArrayList<Integer>();

        for (Integer i = 0; i<=numero1; i++)
        {
            if (i % numero2 == 0)
            {
                lst.add(i);
            }
        }

        System.out.println("los numeros " + lst + " son multiplos de " + numero2);
    }
}
