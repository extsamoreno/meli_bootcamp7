public class Fraccion {
    private int numerador, denominador;

    public Fraccion(){

    }

    public Fraccion(int a, int b){
        this.numerador = a;
        this.denominador = b;
    }

    public Fraccion(int num){
        this.denominador = 1;
        this.numerador = num;
    }

    public Fraccion sumar(Fraccion a, Fraccion b){
        Fraccion resultado = new Fraccion();
        int mcm = this.mcm(a, b);
        resultado.setDenominador(mcm);
        resultado.setNumerador(mcm / a.getDenominador() * a.getNumerador() +
                mcm / b.getDenominador() * b.getNumerador());
        return resultado;
    }

    public Fraccion sumar(Fraccion a, int b)
    {
        Fraccion bFrac = new Fraccion(b);
        return this.sumar(a, bFrac);
    }

    public Fraccion restar(Fraccion a, Fraccion b)
    {
        Fraccion resultado = new Fraccion();
        int mcm = this.mcm(a, b);
        resultado.setDenominador(mcm);
        resultado.setNumerador(mcm / a.getDenominador() * a.getNumerador() -
                mcm / b.getDenominador() * b.getNumerador());
        return resultado;
    }

    public Fraccion restar(Fraccion a, int b)
    {
        Fraccion bFrac = new Fraccion(b);
        return this.restar(a, bFrac);
    }

    public Fraccion multiplicar(Fraccion a, Fraccion b)
    {
        return new Fraccion(
                a.getNumerador() * b.getNumerador(), a.getDenominador() * b.getDenominador()
        );
    }

    public Fraccion multiplicar(Fraccion a, int b)
    {
        Fraccion bFrac = new Fraccion(b);
        return this.multiplicar(a, bFrac);
    }

    public Fraccion dividir(Fraccion a, Fraccion b)
    {
        return new Fraccion(
                a.getNumerador() * b.getDenominador(), a.getDenominador() * b.getNumerador()
        );
    }

    public Fraccion dividir(Fraccion a, int b)
    {
        Fraccion bFrac = new Fraccion(b);
        return this.dividir(a, bFrac);
    }

    public int getNumerador()
    {
        return this.numerador;
    }

    public void setNumerador(int numerador)
    {
        this.numerador = numerador;
    }

    public int getDenominador()
    {
        return this.denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    public int mcm(int num1, int num2)
    {
        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);

        int resultado = (a / this.mcd(num1, num2)) * b;

        return resultado;

    }

    public int mcm(Fraccion f1, Fraccion f2)
    {
        int a = Math.max(f1.getDenominador(), f2.getDenominador());
        int b = Math.min(f1.getDenominador(), f2.getDenominador());

        return this.mcm(a, b);

    }

    public int mcd(int num1, int num2)
    {

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
}
