import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("## HOMEWORK CLASE 1 ##");
        Scanner scan = new Scanner(System.in);
        int num;
        // Ejercicio 1
//        pares();

        // Ejercicio 2
//        multiplos();

        // Ejercicio 3

//        System.out.println("Ingrese un número");
//        num = scan.nextInt();
//        if(esPrimo(num)){
//            System.out.println("el numero es primo");
//        }else{
//            System.out.println("el numero NO es primo");
//        }


        // Ejercicio 4

        System.out.println("Ingrese un número");
        num = scan.nextInt();
        listarPrimos(num);

        // Close scan
        scan.close();

    }

    public static void pares(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese un número");
        int num = scan.nextInt();

        System.out.println("El numero ingresado es " + num);

        for(int i = 1; i <= num; i++){
            System.out.println("#" + i + ": " + i*2);
        }

        scan.close();
    }

    public static void multiplos(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese un número para conocer sus multiplos: ");
        int num = scan.nextInt();
        System.out.println("Cuantos multiplos quieres conocer: ");
        int limit = scan.nextInt();
        System.out.println("-- Lista de multiplos:  ");

        for(int i = 1; i <= limit; i++){
            System.out.println("#" + i + ": " + i*num);
        }

        scan.close();
    }

    public static boolean esPrimo(int number){
        boolean response = true;

        for(int i = 2; i < number; i++){

            if (number % i == 0){
                response = false;
                break;
            }
        }
        return response;
    }

    public static void listarPrimos(int number){
        int j = 0;
        int i = 1;
        for(; j < number; ){
            i++;
            if(esPrimo(i)){
                System.out.println("#" + ++j + " : " + i);

            }
        }
    }

}
