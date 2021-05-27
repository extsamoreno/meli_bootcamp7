package Ejercicio4;

public class Fraccion {
    //Atributos

    int numerador;
    int denominador;

    // Contructor
    public Fraccion(){
        this.numerador=0;
        this.denominador=1;
    }

    public  Fraccion(int numerador, int denominador){
        this.numerador=numerador;
        this.denominador=denominador;
    }

    //Metodos
    public static Fraccion intToFraccion(int num){
        Fraccion fOut = new Fraccion();
        fOut.numerador=num;
        fOut.denominador=1;
        return  fOut;
    }

    public static  Fraccion sumar( Fraccion f1, Fraccion f2){
        Fraccion fOut = new Fraccion();
        fOut.numerador=(f1.numerador* f2.denominador + f1.denominador* f2.numerador);
        fOut.denominador=f1.denominador*f2.denominador;

        return fOut;
    }
    public static  Fraccion sumar( Fraccion f1, int num){
        Fraccion f2 = intToFraccion(num);
        Fraccion fOut = new Fraccion();
        fOut.numerador=(f1.numerador* f2.denominador + f1.denominador* f2.numerador);
        fOut.denominador=f1.denominador*f2.denominador;
        return fOut;
    }



    public Fraccion restar(Fraccion f1, Fraccion f2){
        Fraccion fOut = new Fraccion();
        fOut.numerador=f1.numerador* f2.denominador - f1.denominador * f2.numerador;
        fOut.denominador=f1.denominador*f2.denominador;

        return fOut;
    }
    public static  Fraccion restar( Fraccion f1, int num){
        Fraccion f2 = intToFraccion(num);
        Fraccion fOut = new Fraccion();
        fOut.numerador=(f1.numerador* f2.denominador - f1.denominador* f2.numerador);
        fOut.denominador=f1.denominador*f2.denominador;
        return fOut;
    }
    public static Fraccion multiplicar(Fraccion f1, Fraccion f2){
        Fraccion fOut = new Fraccion();
        fOut.numerador=f1.numerador*  f2.numerador;
        fOut.denominador=f1.denominador*f2.denominador;

        return fOut;
    }
    public static  Fraccion multiplicar(Fraccion f1, int num){
        Fraccion f2 = intToFraccion(num);
        Fraccion fOut = new Fraccion();
        fOut.numerador=f1.numerador*  f2.numerador;
        fOut.denominador=f1.denominador*f2.denominador;

        return fOut;
    }

    public static Fraccion dividir(Fraccion f1, Fraccion f2){
        Fraccion fOut = new Fraccion();
        fOut.numerador=f1.numerador* f2.denominador;
        fOut.denominador=f1.denominador * f2.numerador;
        return fOut;
    }
    public static Fraccion dividir(Fraccion f1, int num ){
        Fraccion f2 = intToFraccion(num);
        Fraccion fOut = new Fraccion();
        fOut.numerador=f1.numerador* f2.denominador;
        fOut.denominador=f1.denominador * f2.numerador;
        return fOut;
    }
}
