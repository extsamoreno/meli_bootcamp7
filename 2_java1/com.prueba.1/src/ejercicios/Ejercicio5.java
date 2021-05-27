package ejercicios;

public class Ejercicio5 {


    public static void construccionDeNumeros(int num,int cant, int veces){
        
        int number= Integer.valueOf(String.valueOf(num).repeat(cant));
        while (veces>0) {
            int contador = 0;
            String sTexto=String.valueOf(number);
            while (sTexto.indexOf(String.valueOf(num)) > -1) {
                sTexto = sTexto.substring(sTexto.indexOf(
                        String.valueOf(num))+String.valueOf(num).length(),sTexto.length());
                contador++;
            }
            if(contador>=cant) {
                System.out.println(number);
                veces--;
            }
            number++;
        }
    }


}
