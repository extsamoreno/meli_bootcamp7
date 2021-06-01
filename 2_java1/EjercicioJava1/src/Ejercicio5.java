import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio5 {

    public static boolean validarRegla(String index,int m, int d){
        ArrayList<String> stringToArray = new ArrayList<>();
        int contador = 0;

        for (int i = 0; i < index.length() ; i++) {
            stringToArray.add(String.valueOf(index.charAt(i)));
        }

        for (String elemento: stringToArray) {
            if (elemento.equals(String.valueOf(d))){
                contador++;
            }
        }

        return (contador >= m ? true : false );
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese n: ");
        int n = sc.nextInt();
        System.out.println("Ingrese m: ");
        int m= sc.nextInt();
        System.out.println("Ingrese d: ");
        int d = sc.nextInt();

        for (int i = 1, j = 0; j < n; i++) {

            if (validarRegla(String.valueOf(i),m,d)){
                System.out.println(i);
                j++;
            }
        }

    }
}
