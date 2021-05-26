package Ejercicios;

public class Ejercicio3 {
    public static boolean es_primo(int n){
        boolean primo = false;
        int contador = 1;

        for(int i=2; i<=n && contador<3; i++){
            if(n%i == 0){
                contador++;
            }
        }
        if(contador == 2){
            primo = true;
        }
        else {
            primo = false;
        }
        return primo;
    }
}
