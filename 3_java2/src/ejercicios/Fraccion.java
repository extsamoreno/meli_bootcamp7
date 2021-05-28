//Crea una clase Fraccion con métodos necesarios para sumar, restar, multiplicar y
//dividir fracciones. Todos los métodos deben estar sobrecargados de modo que también
//puedan usarse para operar entre fracciones y números enteros (por ejemplo: ⅗+2 o ⅝*4).

package ejercicios;

public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion() {
    }

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public static Fraccion sumar(Fraccion a, Fraccion b){
        Fraccion resultado = new Fraccion();
        resultado.denominador = a.denominador * b.denominador;
        resultado.numerador = a.numerador*b.denominador + b.numerador*a.denominador;
        return resultado;
    }

    public static Fraccion sumar(int a, Fraccion b){
        Fraccion resultado = new Fraccion();
        Fraccion na = new Fraccion(a, 1);
        resultado = Fraccion.sumar(na, b);
        return resultado;
    }

    public static Fraccion restar(Fraccion a, Fraccion b){
        Fraccion resultado = new Fraccion();
        resultado.denominador = a.denominador * b.denominador;
        resultado.numerador = a.numerador*b.denominador - b.numerador*a.denominador;

        return resultado;
    }

    public static Fraccion restar(int a, Fraccion b){
        Fraccion resultado = new Fraccion();
        Fraccion na = new Fraccion(a, 1);
        resultado = Fraccion.restar(na, b);
        return resultado;
    }

    public static Fraccion multiplicar(Fraccion a, Fraccion b){
        Fraccion resultado = new Fraccion();
        resultado.denominador = a.denominador * b.denominador;
        resultado.numerador = a.numerador * b.numerador;
        return resultado;
    }

    public static Fraccion multiplicar(int a, Fraccion b){
        Fraccion resultado = new Fraccion();
        Fraccion na = new Fraccion(a, 1);
        resultado = Fraccion.multiplicar(na, b);
        return resultado;
    }

    public static Fraccion dividir(Fraccion a, Fraccion b){
        Fraccion resultado = new Fraccion();
        resultado.numerador = a.numerador * b.denominador;
        resultado.denominador = a.denominador * b.numerador;
        return resultado;
    }

    public static Fraccion dividir(int a, Fraccion b){
        Fraccion resultado = new Fraccion();
        Fraccion na = new Fraccion(a, 1);
        resultado = Fraccion.dividir(na, b);
        return resultado;
    }

}
