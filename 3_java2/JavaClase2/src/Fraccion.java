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
        resultado.setDenominador(a.getDenominador() * b.getDenominador());
        resultado.setNumerador(b.getDenominador()*a.getNumerador() + a.getDenominador()*b.getNumerador());
        return resultado;
    }

    public Fraccion sumar(Fraccion a, int b){
        Fraccion bFrac = new Fraccion(b);
        return this.sumar(a, bFrac);
    }

    public Fraccion restar(Fraccion a, Fraccion b){
        Fraccion resultado = new Fraccion();
        resultado.setDenominador(a.getDenominador() * b.getDenominador());
        resultado.setNumerador(b.getDenominador()*a.getNumerador() - a.getDenominador()*b.getNumerador());
        return resultado;
    }

    public Fraccion restar(Fraccion a, int b){
        Fraccion bFrac = new Fraccion(b);
        return this.restar(a, bFrac);
    }



    public int getNumerador() {
        return this.numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return this.denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }
}
