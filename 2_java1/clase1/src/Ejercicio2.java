import java.util.Scanner;
public class Ejercicio2 {
    
    public static void resolve() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int multiplos = 0, iterador = 1;
        System.out.println("Ingrese n");
        int n = scanner.nextInt();

        System.out.println("Ingrese m");
        int m = scanner.nextInt();

        while (multiplos <= n || iterador < m){

            if(Operations.isMultiplier(m, iterador)){
                multiplos++;
                System.out.println(iterador);
            }

            iterador++;
        }



        scanner.close();
    }
}