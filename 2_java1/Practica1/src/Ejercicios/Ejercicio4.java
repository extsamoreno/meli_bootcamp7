package Ejercicios;

public class Ejercicio4 {
    public static void primosMenores(int n){
        for(int i=2; i<=n; i++){
            if( Ejercicio3.es_primo(i) ){
                System.out.println(i);
            }
        }
    }
}
