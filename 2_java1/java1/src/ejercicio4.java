import java.util.Scanner;

public class ejercicio4 {
/*Desarrollar un programa para mostrar por consola los primeros n números primos,
siendo n un valor que el usuario ingresará por consola.
 */
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingresar numero: ");
    int numero = scanner.nextInt();

    mostrarPrimos(numero);

}

    public static boolean esPrimo(int numero){
        int cont = 2;
        boolean esPrimo=true;
        while ((esPrimo) && (cont!=numero)){
            if (numero % cont == 0)
                esPrimo = false;
            cont++;
        }
        return esPrimo;
    }

    public static void mostrarPrimos(int cantPrimosAEncontrar){
    if(cantPrimosAEncontrar>0)
        System.out.println("1 ");
    int cantPrimosEncontrados=0,i=2;
        while(cantPrimosEncontrados<cantPrimosAEncontrar){
            if(esPrimo(i)){
                System.out.println(i+" ");
                cantPrimosEncontrados++;
            }
            i++;

        }


    }

}
