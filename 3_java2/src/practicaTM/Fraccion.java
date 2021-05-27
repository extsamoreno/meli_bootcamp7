package practicaTM;

import static practicaTM.Utils.mcd;

public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion() {
    }

    public Fraccion(int entero) {
        this.numerador = entero;
        this.denominador = 1;
    }

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion(Fraccion fraccion) {
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

    public Fraccion simplificar(Fraccion fraccion) {
        int mcd = Math.abs(Utils.mcd(fraccion.getDenominador(), fraccion.getNumerador()));
        return new Fraccion(fraccion.getNumerador() / mcd, fraccion.getDenominador() / mcd);
    }

    public Fraccion sumar(Fraccion fraccion) {

        int denominadorNuevo = Utils.mcm(this.denominador, fraccion.getDenominador());
        int n1 = this.numerador * (denominadorNuevo / this.denominador);
        int n2 = fraccion.getNumerador() * denominadorNuevo / fraccion.getDenominador();

        int numeradorNuevo = this.numerador * (denominadorNuevo / this.denominador) + fraccion.getNumerador() * denominadorNuevo / fraccion.getDenominador();

        return simplificar(new Fraccion(numeradorNuevo, denominadorNuevo));
    }

    public Fraccion sumar(int entero) {
        return sumar(new Fraccion(entero));

    }

    public Fraccion restar(Fraccion fraccion) {
        return sumar(new Fraccion(-fraccion.getNumerador(), fraccion.getDenominador()));
    }

    public Fraccion restar(int entero) {
        return sumar(new Fraccion(-entero));
    }


}
