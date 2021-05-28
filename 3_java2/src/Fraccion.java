public class Fraccion {
    private int numerador;
    private int denominador;

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



    public Fraccion() {
    }

    public Fraccion sum(Fraccion a, Fraccion b){
        Fraccion res = new Fraccion();
        res.setNumerador(a.getNumerador()*b.getDenominador() + b.getNumerador() * a.getDenominador());
        res.setDenominador(a.getDenominador()*b.getDenominador());
        return res;

    }
    public Fraccion rest(Fraccion a, Fraccion b){
        Fraccion res = new Fraccion();
        res.setNumerador(a.getNumerador()*b.getDenominador() - b.getNumerador() * a.getDenominador());
        res.setDenominador(a.getDenominador()*b.getDenominador());
        return res;
    }
    public Fraccion multiply(Fraccion a, Fraccion b){
        Fraccion res = new Fraccion();
        res.setNumerador(a.getNumerador()*b.getNumerador());
        res.setDenominador(a.getDenominador()*b.getDenominador());
        return res;
    }
    public Fraccion divide(Fraccion a, Fraccion b){
        Fraccion res = new Fraccion();
        res.setNumerador(a.getNumerador()*b.getDenominador());
        res.setDenominador(a.getDenominador()*b.getNumerador());
        return res;
    }


    public Fraccion sum(Fraccion a, int b){
        Fraccion bF = new Fraccion();
        bF.setNumerador(b);
        bF.setDenominador(1);
        return sum(a,bF);

    }
    public Fraccion rest(Fraccion a, int b){
        Fraccion bF = new Fraccion();
        bF.setNumerador(b);
        bF.setDenominador(1);
        return rest(a,bF);
    }
    public Fraccion multiply(Fraccion a, int b){
        Fraccion bF = new Fraccion();
        bF.setNumerador(b);
        bF.setDenominador(1);
        return multiply(a,bF);
    }
    public Fraccion divide(Fraccion a, int b){
        Fraccion bF = new Fraccion();
        bF.setNumerador(b);
        bF.setDenominador(1);
        return divide(a,bF);
    }

}


