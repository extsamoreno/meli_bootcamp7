package tm;

public class Fraccion {

    private int numerador, denominador;

    public Fraccion() {
    }

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion sumar(Fraccion f) {

        Fraccion resultado = new Fraccion();

        int denomComun = mcm(this.denominador, f.getDenominador());

        int numerador1 = obtenerNumerador(denomComun, this.denominador, this.numerador);
        int numerador2 = obtenerNumerador(denomComun, f.getDenominador(), f.getNumerador());

        int numeradorRes = numerador1 + numerador2;

        resultado.setNumerador(numeradorRes);
        resultado.setDenominador(denomComun);

        return resultado;
    }

    public Fraccion sumar(int entero) {
        return sumar(new Fraccion(entero, 1));
    }

/*    public Fraccion dividir(int entero) {
        Fraccion f2 = new Fraccion(entero, 1);
        return dividir()
    }*/

    public Fraccion restar(Fraccion f) {

        Fraccion resultado = new Fraccion();

        int denomComun = mcm(this.denominador, f.getDenominador());

        int numerador1 = obtenerNumerador(denomComun, this.denominador, this.numerador);
        int numerador2 = obtenerNumerador(denomComun, f.getDenominador(), f.getNumerador());

        int numeradorRes = numerador1 - numerador2;

        resultado.setNumerador(numeradorRes);
        resultado.setDenominador(denomComun);

        return resultado;
    }

    public Fraccion restar(int entero) {
        return restar(new Fraccion(entero, 1));
    }

    public Fraccion multiplicar(Fraccion f) {

        int numerador = this.numerador * f.getNumerador();
        int denominador = this.denominador * f.getDenominador();

        return simplificar(numerador, denominador);
    }

    public Fraccion multiplicar(int entero){
        return multiplicar(new Fraccion(entero,1));
    }

    public Fraccion dividir(Fraccion f) {

        int numerador = this.numerador * f.getDenominador();
        int denominador = this.denominador * f.getNumerador();

        return simplificar(numerador, denominador);
    }

    public Fraccion dividir (int entero){
        return dividir(new Fraccion(entero,1));
    }

    public static Fraccion simplificar(int numerador, int denominador) {

        Fraccion resultado = new Fraccion();
        int mcd = Math.abs(mcd(numerador, denominador));

        resultado.setNumerador(numerador / mcd);
        resultado.setDenominador(denominador / mcd);

        return resultado;
    }

    public static int mcm(int num1, int num2) {
        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);

        return (a / mcd(num1, num2)) * b;
    }

    public static int mcd(int num1, int num2) {

        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);

        int resultado;
        do {
            resultado = b;
            b = a % b;
            a = resultado;

        } while (b != 0);

        return resultado;
    }

    public static int obtenerNumerador(int denomComun, int denominador, int numerador) {
        return denomComun / denominador * numerador;
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

    @Override
    public String toString() {
        return numerador +
                "/" + denominador;
    }
}
