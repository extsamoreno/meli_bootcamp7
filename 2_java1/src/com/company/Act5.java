package com.company;
import java.util.Scanner;

public class Act5 {
    public static int charCount(String s,char c)
    {
        int i=0;
        int cont=0;
        while( i<s.length() )
        {
            if( s.charAt(i)==c)
            {
                cont++;
            }

            i++;
        }

        return cont;
    }

    public static boolean cumpleCondicion(int i,int m,int d)
    {
        return charCount(Integer.toString(i),(char)(d+'0'))==m;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el valor de n: ");
        int n=scanner.nextInt();

        System.out.print("Ingrese el valor de m: ");
        int m=scanner.nextInt();

        System.out.print("Ingrese el valor de d: ");
        int d=scanner.nextInt();

        int i=0;
        int cont=0;
        while( cont<n )
        {
            if( cumpleCondicion(i,m,d) )
            {
                cont++;
                System.out.println(i);
            }

            i++;
        }



        scanner.close();
    }
}
