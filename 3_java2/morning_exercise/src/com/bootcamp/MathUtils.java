package com.bootcamp;

public class MathUtils {

    public static int minimoComunMultiplo(int num1, int num2) {
        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);

        int resultado = (a / maximoComunDivisor(num1, num2)) * b;

        return resultado;
    }

    public static int maximoComunDivisor(int num1, int num2) {

        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);

        int resultado = 0;
        do {
            resultado = b;
            b = a % b;
            a = resultado;

        } while (b != 0);

        return resultado;
    }
}
