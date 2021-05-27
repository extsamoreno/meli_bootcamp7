package ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio4 {

    public static void nPrimerosPrimos(int cantidad){
        List<Integer> primos = new ArrayList<>();
        int cant = 0,i = 2;
        while (cant<cantidad){
            boolean isPrimo=true;
            for (int j = 0; j < i && i!=2; j++) {
                if(j+1> primos.size()){
                    break;
                }
                if(i%primos.get(j)==0){
                    isPrimo=false;
                    break;
                }
            }
            if(isPrimo){
                System.out.println(i);
                primos.add(i);
                cant++;
            }
            i++;
        }
    }
}
