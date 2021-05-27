package Ejercicio4;

public class Main {
    //Pruebas ejercicio 4
    public static void main(String[] args) {
        Fraccion f1 = new Fraccion(3,5);
        Fraccion f2 = new Fraccion(7,5);
        int num=5;
        Fraccion f3 =Fraccion.sumar(f1,num);
        System.out.println(f3.numerador +"/"+ f3.denominador);
        Fraccion f4 =Fraccion.multiplicar(f1,2);
        System.out.println(f4.numerador +"/"+ f4.denominador);
        Fraccion f5 =Fraccion.dividir(f1,f3);
        System.out.println(f5.numerador +"/"+ f5.denominador);
    }
}
