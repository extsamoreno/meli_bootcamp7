public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion() {
    }

    public static Fraccion suma(Fraccion a, Fraccion b){
        Fraccion resultado = new Fraccion();
        resultado.denominador = a.denominador * b.denominador;
        resultado.numerador = a.numerador*b.denominador + b.numerador*a.denominador;

        return resultado;
    }

    public static Fraccion suma(int a, Fraccion b){
        Fraccion resultado = new Fraccion();
        Fraccion na = new Fraccion(a, 1);
        resultado = Fraccion.suma(na, b);

        return resultado;
    }

    public static Fraccion resta(Fraccion a, Fraccion b){
        Fraccion resultado = new Fraccion();
        resultado.denominador = a.denominador * b.denominador;
        resultado.numerador = a.numerador*b.denominador - b.numerador*a.denominador;

        return resultado;
    }

    public static Fraccion resta(int a, Fraccion b){
        Fraccion resultado = new Fraccion();
        Fraccion na = new Fraccion(a, 1);
        resultado = Fraccion.resta(na, b);

        return resultado;
    }

    public static Fraccion multiplicacion(Fraccion a, Fraccion b){
        Fraccion resultado = new Fraccion();
        resultado.numerador = a.numerador * b.numerador;
        resultado.denominador = a.denominador * b.denominador;

        return resultado;
    }

    public static Fraccion multiplicacion(int a, Fraccion b){
        Fraccion resultado = new Fraccion();
        Fraccion na = new Fraccion(a, 1);
        resultado = Fraccion.multiplicacion(na, b);

        return resultado;
    }

    public static Fraccion divicion(Fraccion a, Fraccion b){
        Fraccion resultado = new Fraccion();
        resultado.numerador = b.denominador * a.numerador;
        resultado.denominador = b.numerador * a.denominador;

        return resultado;
    }

    public static Fraccion divicion(int a, Fraccion b){
        Fraccion resultado = new Fraccion();
        Fraccion na = new Fraccion(a, 1);
        resultado = Fraccion.divicion(na, b);

        return resultado;
    }

    @Override
    public String toString() {
        return  numerador + "/" +  denominador;

    }
}
