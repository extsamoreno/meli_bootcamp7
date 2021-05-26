package com.bootcamp;

public class Numbers {

    public static void nPairNumbers(int n) {
        int counterPair = 0;

        for (int i = 0; counterPair < n; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                counterPair++;
            }
        }
    }

    public static void nMultiplesOfM(int n, int m) {
        int counterMultiples = 0;

        for (int i = m; counterMultiples < n; i++) {
            if (i % m == 0) {
                System.out.println(i);
                counterMultiples++;
            }
        }
    }

    public static boolean isPrimeNumber(int n) {
        int counterDivisors = 0;

        for (int i = n; i > 0; i--) {
            if (n % i == 0) {
                counterDivisors++;
            }
        }

        return counterDivisors == 2;
    }


    public static void nPrimeNumbers(int n) {

        int counterPrimes = 0;

        for (int i = 0; counterPrimes < n; i++) {
            if (isPrimeNumber(i)) {
                System.out.println(i);
                counterPrimes++;
            }
        }
    }

    public static void nNumbersWithMDigitsD(int n, int m, int d) {
        int countNumbers = 0;
        int countRepetitions = 0;
        String aux;

        for (int i = 0; countNumbers < n; i++) {
            aux = String.valueOf(i);

            for (int j = 0; j < aux.length(); j++) {
                if(Character.getNumericValue(aux.charAt(j)) == d) {
                    countRepetitions++;
                }
            }

            if (countRepetitions >= m) {
                System.out.println(i);
                countNumbers++;
            }

            countRepetitions = 0;
        }

    }


}
