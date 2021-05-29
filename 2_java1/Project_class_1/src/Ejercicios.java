import java.util.Scanner;

public class Ejercicios {
    public static void ejercicio_1(){
        Scanner scanner = new Scanner(System.in);
        int n_limite;
        System.out.print("Ingresa el número límite: ");
        n_limite = scanner.nextInt();
        for(int i = 0; i<=n_limite; i++){
            if(i%2==0){
                System.out.println("valor de número par:" + i);
            }

        }
    }

    public static void ejercicio_2(){
        Scanner scanner = new Scanner(System.in);
        int num_mult;
        int lim_mult;
        System.out.print("Ingresa el número para calcular sus múltiplos: ");
        num_mult = scanner.nextInt();
        System.out.print("Ingresa la cantidad de múltiplos a calcular: ");
        lim_mult = scanner.nextInt();

        int cmult = 0;
        int i=0;
        while(cmult != lim_mult){
            if (i%num_mult==0){
                System.out.println("Múltiplo " + i +  " encontrado");
                cmult++;
            }
            i++;
        }

    }

    public static void ejercicio_3(){
        Scanner scanner = new Scanner(System.in);
        int num;
        boolean bandera;
        bandera = true;
        System.out.print("Ingrese el número a analizar: ");
        num = scanner.nextInt();
        for(int i=2;i<num;i++){
            if (num%i==0) {
                bandera = false;
                break;
            }
        }
        if(bandera){
            System.out.println("El número "+num+" es primo.");
        }
        else
        {
            System.out.println("El número "+num+" NO es primo.");
        }
    }
    public static void ejercicio_4() {
        Scanner scanner = new Scanner(System.in);
        int num;
        int cant_num;
        boolean bandera;
        int cant_iter;
        int n_actual;
        bandera = true;
        System.out.print("Ingrese la cantidad de números a analizar: ");
        cant_num = scanner.nextInt();
        cant_iter = 1;
        n_actual=2;
        if (cant_num >=1){
            System.out.println("El número 1 es primo.");
        }
        while(cant_iter<cant_num){

            for(int i=2;i<n_actual;i++){
                if (n_actual%i==0) {
                    bandera = false;
                    break;
                }
            }

            if(bandera) {
                System.out.println("El número " + n_actual + " es primo.");
                cant_iter++;


            }
            bandera = true;
            n_actual++;
        }

    }
    public static void ejercicio_5(){
        int n_numeros;
        int cant_digitos;
        String n_digito;
        int cuenta_digitos;
        String ist;
        cuenta_digitos = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la cantidad de números: ");
        n_numeros = scanner.nextInt();
        System.out.println("Ingresa el digito a verificar: ");
        n_digito = scanner.next();
        System.out.println("Ingresa la cantidad de digitos a verificar: ");
        cant_digitos = scanner.nextInt();
        int cant_actual = 0;
        int dig_actual = 0;
        while(cant_actual<n_numeros){

            ist = Integer.toString(dig_actual);
            //System.out.println(ist);
            for(int j=0; j<ist.length();j++){
                //System.out.println(Character.toString(ist.charAt(j)));
                if(n_digito.equals(Character.toString(ist.charAt(j)))) {
                    cuenta_digitos++;

                }
            }
            if(cuenta_digitos == cant_digitos){
                System.out.println("Dígito encontrado: " + ist);
                cant_actual++;
            }
            cuenta_digitos = 0;
            dig_actual++;
        }


    }
}
