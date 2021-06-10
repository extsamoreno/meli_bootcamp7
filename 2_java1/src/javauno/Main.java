package javauno;

public class Main {
    public static void main(String[] args) {
        /*
        Ejercicio 1
        System.out.println("Seleccione un número para ver sus pares anteriores");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        for (int i = 0; i<= number; i++) {
            if(i%2 == 0) System.out.println(i);
        }
        */

        /*
        Ejercicio 2
        System.out.println("Escoja un número");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println("Cuantos múltiplos desea obtener?");
        int multiplos = scanner.nextInt();
        for (int i = 1; i<=multiplos; i++) {
            System.out.println(i*number);
        }
        */

        /*
        Ejercicio 3
        System.out.println("Seleccione un número para ver si es primo o no");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        boolean primo = true;
        for (int i = 2; i<number; i++) {
            if (number % i == 0) primo = false;
            break;
        }
        if (primo) System.out.println("El número ingresado es primo");
        else System.out.println("El número ingresado NO es primo");
        */


        /*
        Ejercicio 4
        System.out.println("Seleccione un número para conocer sus primos anteriores");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
            for (int i = 2; i<=number; i++) {
                int counter = 0;
                for (int j = 2; j < i; j ++) {
                    if(i%j == 0) {
                        counter++;
                        break;
                    }
                } if(counter == 0) System.out.println(i);
            }
        }
        */

        /* Ejercicio 5

        public static int digitCounter(int digit; int cant) {
            String st = "" + digit;
            System.out.println(st);
        }
        Scanner scanner = new Scanner(System.in);
        // System.out.println("Seleccione la cantidad de números deseados");
        //int number = scanner.nextInt();
        System.out.println("Seleccione cantidad de dígitos a matchear");
        int numDigits = scanner.nextInt();
        System.out.println("Seleccione el dígito a matchear");
        int oneDigit = scanner.nextInt();
        digitCounter(oneDigit, numDigits);

        }
        */
    }
}
