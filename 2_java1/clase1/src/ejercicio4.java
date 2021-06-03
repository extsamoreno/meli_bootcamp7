import java.util.Scanner;
public class ejercicio4 {

    public static boolean esPrimo(int numero) {
        int contador = 2;
        boolean primo = true;
        while ((primo) && (contador != numero)) {
            if (numero % contador == 0)
                primo = false;
            contador++;


        }
        return primo;
    }
}


