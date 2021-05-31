import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {
        System.out.println("## HOMEWORK CLASE 1 ##");
        System.out.println("     ejercicio 5  ");
        Scanner scan = new Scanner(System.in);
        int n, m, d, count;
        count = 0;

        System.out.println("Ingrese la cantidad de numeros que quiere listar");
        n = scan.nextInt();
        System.out.println("Ingrese la cantidad veces que un digito se tiene que repetir");
        m = scan.nextInt();
        System.out.println("Ingrese el digito que se repite");
        d = scan.nextInt();

        System.out.println("Buscar los " + n + " primeros numeros que contienen " + m + "  veces la cifra " + d);

        int i = (int) Math.pow(10, m-1) * d ;

        while (count < n ){
            if(checkIsOK(i,m,d)){
                count++;
                System.out.println("#"+ count + ": " + i);
            }
            i++;
        }
        // Close scan
        scan.close();
    }



    public static boolean checkIsOK(int number, int m, int d) {
        String str;
        int count = 0;
        boolean result = false;
        str = Integer.toString(number);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == Integer.toString(d).charAt(0)) {
                count++;
            }
        }

        if (count >= m) result = true;

        return result;
    }
}