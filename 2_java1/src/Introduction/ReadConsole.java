package Introduction;

import java.util.Scanner;

public class ReadConsole {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese un numero entero:");
        int n = sc.nextInt();
        System.out.println("Ingrese un nombre:");
        String s =sc.next();
        System.out.println("Numero: "+n+", nombre: "+s);
        sc.close();
    }
}
