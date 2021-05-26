import java.util.Scanner;

public class nPrimos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese n: ");
        int n = sc.nextInt();
        int cont = 0;
        int numero = 1;

        while (cont != n) {
            int div = 0;
            for (int i = 1; i <= numero; i++) {
                if (numero % i == 0) {
                    div++;
                }
            }
            if (div == 1 || div == 2) {
                System.out.println(numero);
                cont++;
            }
            numero++;
        }
    }
}
