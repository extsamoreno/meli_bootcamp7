package ejercicio4;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion() {
    }

    public Fraccion(Fraccion fraccion){
        this.numerador = fraccion.getNumerador();
        this.denominador = fraccion.getDenominador();
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
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
        resultado.numerador = a.numerador * b.numerador;
        resultado.denominador = a.denominador * b.denominador;
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
        resultado.numerador = a.numerador / b.denominador;
        resultado.denominador = a.denominador / b.numerador;
        return resultado;
    }

    public static Fraccion dividir(int a, Fraccion b){
        Fraccion resultado = new Fraccion();
        Fraccion na = new Fraccion(a, 1);
        resultado = Fraccion.dividir(na, b);
        return resultado;
    }

    @Override
    public String toString() {
        return "Fraccion{" +
                "numerador=" + numerador +
                ", denominador=" + denominador +
                ',' + numerador + '/' + denominador +
                '}';
    }
}