public class Fraccion {
    private int numerador, denominador;

    public Fraccion() {
    }

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion(int numerador) {
        this.numerador = numerador;
        this.denominador = 1;
    }

    public static int mcm(int num1, int num2) {
        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);

        return (a / mcd(num1, num2)) * b;
    }

    public static int mcd(int num1, int num2) {

        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);

        int resultado = 0;
        do {
            resultado = b;
            b = a % b;
            a = resultado;

        } while (b != 0);

        return resultado;
    }

    public void simplificar() {
        int mcd = Math.abs(mcd(this.getNumerador(),this.getDenominador()));
        this.setNumerador(this.getNumerador()/mcd);
        this.setDenominador(this.getDenominador()/mcd);
    }

    public Fraccion sumar(Fraccion fr) {
        Fraccion resultado = new Fraccion();

        resultado.setDenominador(mcm(this.getDenominador(), fr.getDenominador()));

        int nuevoNumerador1 = resultado.getDenominador() / this.getDenominador() * this.getNumerador();
        int nuevoNumerador2 = resultado.getDenominador() / fr.getDenominador() * fr.getNumerador();
        resultado.setNumerador(nuevoNumerador1 + nuevoNumerador2);

        resultado.simplificar();
        return resultado;
    }

    public Fraccion sumar(int num) {
        return this.sumar(new Fraccion(num));
    }

    public Fraccion restar(Fraccion fr) {
        return this.sumar(new Fraccion(-fr.getNumerador(), fr.getDenominador()));
    }

    public Fraccion restar(int num) {
        return this.sumar(new Fraccion(-num));
    }

    public Fraccion multiplicar(Fraccion fr) {
        Fraccion resultado = new Fraccion();
        resultado.setNumerador(this.getNumerador() * fr.getNumerador());
        resultado.setDenominador(this.getDenominador() * fr.getDenominador());

        resultado.simplificar();
        return resultado;
    }

    public Fraccion multiplicar(int num) {
        return this.multiplicar(new Fraccion(num));
    }

    public Fraccion dividir(Fraccion fr) {
        return this.multiplicar(new Fraccion(fr.getDenominador(), fr.getNumerador()));
    }

    public Fraccion dividir(int num) {
        return this.multiplicar(new Fraccion(1, num));
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
}
