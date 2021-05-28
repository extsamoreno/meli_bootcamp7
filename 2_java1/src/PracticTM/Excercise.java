package PracticTM;

import java.util.Scanner;

public class Excercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese n");
        int n = sc.nextInt();
        System.out.println("Ingrese m");
        int m = sc.nextInt();
        System.out.println("Ingrese d");
        int b = sc.nextInt();
        int cont = 0;
        for (int i = 0; i < n; ) {
            cont++;
            String valor = String.valueOf(cont);
            if (valor.length() >= m) {
                if (contChart(m, b, valor)) {
                    System.out.println(valor);
                    i++;
                }
            }
        }
    }

    public static boolean contChart(int m, int b, String valor) {
        int cont = 0;
        for (int i = 0; i < valor.length(); i++) {
            String t = String.valueOf(valor.charAt(i));
            if (t.equals(String.valueOf(b))) {
                cont++;
            }
        }
        if (cont >= m)
            return true;
        return false;
    }
}
