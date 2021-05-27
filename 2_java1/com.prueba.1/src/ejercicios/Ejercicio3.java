package ejercicios;

public class Ejercicio3 {


    public static void esPrimo(int numero){
        int vecesDividido= 0;
        for (int i = 2; i < (numero/2)+1 ; i++) {
            if( numero % i ==0){
                vecesDividido++;
            }
        }
        if(vecesDividido>=1 || numero==1){
            System.out.println(numero +" NO es un numero primo");
        }else{
            System.out.println(numero +" es un numero primo");
        }
    }


}
