public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion() {
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

    public static Fraccion resta(Fraccion a, Fraccion b){
        Fraccion resultado = new Fraccion();
        resultado.denominador = a.denominador * b.denominador;
        resultado.numerador = a.numerador*b.denominador - b.numerador*a.denominador;

        return resultado;
    }
}
