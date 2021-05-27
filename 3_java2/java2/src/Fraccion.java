public class Fraccion {
    /*Ejercicio 4
    Crea una clase Fraccion con métodos necesarios para sumar, restar, multiplicar y dividir fracciones.
    Todos los métodos deben estar sobrecargados de modo que también puedan
    usarse para operar entre fracciones y números enteros (por ejemplo: ⅗+2 o ⅝*4). */

    public static void main(String[] args) {
        int fraccion1 = 2;
        double fraccion2 = 2.6;

        System.out.println(Fraccion.sumar(fraccion1,fraccion2));
        System.out.println(Fraccion.restar(fraccion1,fraccion2));
        System.out.println(Fraccion.mutiplicar(fraccion1,fraccion2));
        System.out.println(Fraccion.dividir(fraccion1,fraccion2));
    }



    public static double sumar (double f1, double f2){
        return f1+f2;
    }

    public static double restar (double f1, double f2){
        return (f1-f2);
    }

    public static double mutiplicar (double f1, double f2){
        return f1*f2;
    }

    public static double dividir (double f1, double f2){
            return f1/f2;
    }

    public static double convertirAFraccion(int entero){
        double d = (double)entero;
        return d;
    }


}
