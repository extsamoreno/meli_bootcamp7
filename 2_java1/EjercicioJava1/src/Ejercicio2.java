import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresar los primeros n: ");
        int cantidadAMostrar = sc.nextInt();
        System.out.println("Ingresar numero al que se le sacaran los multiplos: ");
        int numeroMultiplos = sc.nextInt();

        //System.out.println("n " + cantidadAMostrar+ " m " + numeroMultiplos);
        double resultado;
        for (int i = 0; i < cantidadAMostrar ; i++) {
            System.out.println(i*numeroMultiplos);
        }
    }
}
