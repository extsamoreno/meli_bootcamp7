public class Fraccion {

    private int numerador, denominador;

    public Fraccion () {}
    public Fraccion (int denominador, int numerador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion sumar (Fraccion a, Fraccion b) {
        Fraccion resultado = new Fraccion();
        resultado.denominador = a.denominador * b.denominador;
        resultado.numerador = (resultado.denominador/a.denominador*a.numerador) +
                (resultado.denominador/b.denominador*b.numerador);

        return resultado;
    }

    public Fraccion sumar (int a, Fraccion b) {
        return sumar(new Fraccion(a, 1), b);
    }

    public Fraccion restar (Fraccion a, Fraccion b) {
        Fraccion resultado = new Fraccion();
        resultado.denominador = a.denominador * b.denominador;
        resultado.numerador = (resultado.denominador/a.denominador*a.numerador) -
                (resultado.denominador/b.denominador*b.numerador);

        return resultado;
    }

    public Fraccion restar (int a, Fraccion b) {
        return restar(new Fraccion(a, 1), b);
    }

    public Fraccion multiplicar (Fraccion a, Fraccion b) {
        return (new Fraccion(a.denominador*b.denominador, a.numerador*b.numerador));
    }

    public Fraccion multiplicar (int a, Fraccion b) {
        Fraccion nueva = new Fraccion(a, 1);
        return (new Fraccion(nueva.denominador*b.denominador, nueva.numerador*b.numerador));
    }

    public Fraccion dividir (Fraccion a, Fraccion b) {
        return (new Fraccion(a.denominador*b.numerador, a.numerador*b.denominador));
    }

    public Fraccion dividir (int a, Fraccion b) {
        Fraccion nueva = new Fraccion(a, 1);
        return (new Fraccion(nueva.denominador*b.numerador, nueva.numerador*b.denominador));
    }
}

/*Crea una clase Fraccion con métodos necesarios para sumar, restar, multiplicar y dividir fracciones. Todos los métodos deben estar sobrecargados de modo que también puedan usarse para operar entre fracciones y números enteros (por ejemplo: ⅗+2 o ⅝*4). */
