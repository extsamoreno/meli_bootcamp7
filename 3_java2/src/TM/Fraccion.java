package TM;

public class Fraccion {


    private int num, den;

    public Fraccion() {}

    public Fraccion(int num, int den) {
        this.num = num;
        this.den = den;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setDen(int den) {
        this.den = den;
    }

    public int getNum() {
        return this.num;
    }

    public int getDen() {
        return this.den;
    }

    public Fraccion multiplicacion(int num, int den){
        this.num *= num;
        this.den *= den;
        return this;
    }

    public Fraccion multiplicacion(int a){
        this.num *= a;
        this.den *= 1;
        return this;
    }

    public Fraccion division(int num, int den){
        return (this.multiplicacion(den, num));
    }

    public Fraccion division(int a){
        this.num *= 1;
        this.den *= a;
        return this;
    }

    public Fraccion suma(int num, int den) {
        Fraccion fracAuxiliar = new Fraccion();
        fracAuxiliar.setDen(this.den * den);
        fracAuxiliar.setNum((num*this.den) + (den*this.num));
        return fracAuxiliar;
    }

    public Fraccion suma(int num) {
        int den = 1;
        Fraccion fracAuxiliar = new Fraccion();
        fracAuxiliar.setDen(this.den * den);
        fracAuxiliar.setNum((num*this.den) + (den*this.num));
        return fracAuxiliar;
    }

    public Fraccion resta(int num, int den) {
        Fraccion fracAuxiliar = new Fraccion();
        fracAuxiliar.setDen(this.den * den);
        fracAuxiliar.setNum(-(num*this.den) + (den*this.num));
        return fracAuxiliar;
    }

    public Fraccion resta(int num) {
        int den = 1;
        Fraccion fracAuxiliar = new Fraccion();
        fracAuxiliar.setDen(this.den * den);
        fracAuxiliar.setNum(-(num * this.den) + (den * this.num));
        return fracAuxiliar;
    }
}
