public class Fraccion {

    private int numerador,denominador;

    public Fraccion() {
    }

    public Fraccion sumar(Fraccion a , Fraccion b){
        Fraccion resultado = new Fraccion();
        resultado.setNumerador(a.getNumerador()*b.getDenominador()+(b.getNumerador()*a.getDenominador()));
        resultado.setDenominador(a.getDenominador()*b.getDenominador());
        return resultado;
    }

    public Fraccion sumar(Fraccion a , int numerador , int denominador){
        Fraccion resultado = new Fraccion();
        resultado.setNumerador(a.getNumerador()*denominador+(numerador*a.getDenominador()));
        resultado.setDenominador(a.getDenominador()*denominador);
        return resultado;
    }

    public Fraccion sumar(Fraccion a , int numero){
        Fraccion resultado = new Fraccion();
        resultado.setNumerador(a.getNumerador()*1+(numero*a.getDenominador()));
        resultado.setDenominador(a.getDenominador()*1);
        return resultado;
    }

    public Fraccion multiplicacion(Fraccion a , Fraccion b){
        Fraccion resultado = new Fraccion();
        resultado.setNumerador(a.getNumerador()*b.getNumerador());
        resultado.setDenominador(a.getDenominador()*b.getDenominador());
        return resultado;
    }

    public Fraccion division(Fraccion a , Fraccion b){
        Fraccion resultado = new Fraccion();
        resultado.setNumerador(a.getNumerador()*b.getDenominador());
        resultado.setDenominador(a.getDenominador()*b.getNumerador());
        return resultado;
    }

    public Fraccion resta(Fraccion a , Fraccion b){
        Fraccion resultado = new Fraccion();
        resultado.setNumerador(a.getNumerador()*b.getDenominador()-(b.getNumerador()*a.getDenominador()));
        resultado.setDenominador(a.getDenominador()*b.getDenominador());
        return resultado;
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
