import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el valor de los primero n a evaluar: ");
        int n = scanner.nextInt();

        System.out.print("Ingrese la cantidad de veces que quiere que el digito m aparezca en los numeros: ");
        int m = scanner.nextInt();

        System.out.print("Ingrese el digito a buscar en los numeros: ");
        int d = scanner.nextInt();

        int numero = 0;
        char dd = (char)d;
        String num = Integer.toString(numero);

        int cantidadNumeros = 0;
        for(int i=0 ; i<n ; i++) {  //cantidad de numero que quiere el usuario

            for(int j =0 ; j< numero ; j++) { //itero numeros hasta llegar a alguno que cumpla con las condiciones del usuario
                numero++;
                if (contarCaracteres(num, dd) == m) {
                    System.out.println(numero);
                    cantidadNumeros++;
                    if(cantidadNumeros == n) return;
                }
            }
        }







      /*  int contadorNumerosQueCumplen = 0;
        int numero = 0;
        int auxd = 0;
        int numeroAux;

        for(int cont =0 ; cont <= contadorNumerosQueCumplen; cont ++) {
            numero++;
            System.out.println("numero "+numero);

            numeroAux = numero;
            for(int j =0 ; j < numero ; j++) {

                System.out.println("numero aux "+numeroAux);
                int ultimoValor = UltimoValor(numeroAux);

                System.out.println("ultimo valor "+ultimoValor);
                numeroAux = (int) numeroAux/10; //voy cortando el numero
                System.out.println("numero aux truncado "+ultimoValor);

                if (ultimoValor == d) {
                    auxd++;
                }
                if (auxd == m) {
                    System.out.println(numero);
                    contadorNumerosQueCumplen++;
                }
            }

        }

    }
    private static int UltimoValor(int numero) {
        double num = numero/10;
        String str = String.valueOf(num);
        int decNumberInt = Integer.parseInt(str.substring(str.indexOf('.') + 1));

        return decNumberInt;
    }*/
    }
    public static int contarCaracteres(String cadena, char caracter) {
        int posicion, contador = 0;
        //se busca la primera vez que aparece
        posicion = cadena.indexOf(caracter);
        while (posicion != -1) { //mientras se encuentre el caracter
            contador++;           //se cuenta
            //se sigue buscando a partir de la posición siguiente a la encontrada
            posicion = cadena.indexOf(caracter, posicion + 1);
        }
        return contador;
    }
}
