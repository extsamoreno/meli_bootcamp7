import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingresa un número");
        int n = scanner.nextInt();
        System.out.println("Por favor ingresa el número de dígitos que deseas ver de un número");
        int m = scanner.nextInt();
        System.out.println("Por favor ingresa el dígito que deseas ver");
        String d = scanner.next();
        int i = (int) Math.pow(10, m - 1);
        int numberPrint = 0;
        while (numberPrint < n) {
            String numero = String.valueOf(i);
            int contadorDigitos = 0;
            for (int k = 0; k < numero.length(); k++) {
                String digito = String.valueOf(numero.charAt(k));
                if (digito.equals(d)) {
                    contadorDigitos++;
                }
            }
            if (contadorDigitos == m) {
                System.out.println(numero);
                numberPrint++;
            }
            i++;
        }


    }
}
