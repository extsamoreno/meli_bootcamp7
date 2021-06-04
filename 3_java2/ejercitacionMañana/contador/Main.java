package contador;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Contador cont = new Contador();
        int n;

        System.out.print("Introduce un valor para inicializar el contador: ");
        n = input.nextInt();

        cont.setContador(n);
        cont.incrementar();
        System.out.println(cont.getContador());
        cont.decrementar();
        System.out.println(cont.getContador());

        cont.setContador(5);
        System.out.println(cont.getContador());

        Contador cont2 = new Contador(10);
        System.out.println(cont2.getContador());
        cont2.incrementar();
        cont2.incrementar();
        System.out.println(cont2.getContador());
        System.out.println(cont.getContador());

        Contador cont3 = new Contador(cont2);
        System.out.println("cont3.getContador() = " + cont3.getContador());
        System.out.println("cont2.getContador() = " + cont2.getContador());
    }
}