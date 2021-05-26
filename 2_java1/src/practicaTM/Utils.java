package practicaTM;

public class Utils {

    public static boolean esMultiploDe(int dividendo, int divisor) {
        return dividendo % divisor == 0;
    }

    public static boolean esPrimo(int numero) {
        int i = 1;
        int divisores = 0;
        if (numero <= 0) {
            return false;
        }
        if (numero == 1) {
            return true;
        }

        while (i <= numero) {
            if (numero % i == 0) {
                divisores++;
            }
            i++;
        }

        if (divisores != 2) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean tieneLaCantidadBuscadaDeDigitos(int numero, int digitoBuscado, int cantidadBuscada) {
        return cantidadBuscada <= cantidadDeDigitosEn(numero, digitoBuscado);
    }

    public static int cantidadDeDigitosEn(int numero, int digitoBuscado) {
        int cantidad = 0;

        while (numero > 9) {
            int resto = numero % 10;
            numero = numero / 10;
            if (resto == digitoBuscado) {
                cantidad++;
            }
        }
        if (numero == digitoBuscado) {
            cantidad++;
        }
        return cantidad;
    }
}
