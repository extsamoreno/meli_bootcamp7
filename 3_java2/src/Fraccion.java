public class Fraccion {

    public int numerador, denominador;

    public Fraccion() {
    }

    public Fraccion suma(Fraccion frac1, Fraccion frac2){
        Fraccion resultado = new Fraccion();

        resultado.setNumerador(frac1.getNumerador()* frac2.getNumerador()+ frac2.getNumerador()* frac1.getDenominador());
        resultado.setDenominador(frac1.getDenominador()* frac2.getDenominador());

        return resultado;
    }

    public Fraccion suma(Fraccion frac1, int num){
        Fraccion resultado = new Fraccion();
        Fraccion fracAux = new Fraccion();
        fracAux.setNumerador(num);
        fracAux.setDenominador(1);

        resultado.setNumerador(frac1.getNumerador()* fracAux.getNumerador()+ fracAux.getNumerador()* frac1.getDenominador());
        resultado.setDenominador(frac1.getDenominador()* fracAux.getDenominador());

        return resultado;
    }

    public Fraccion resta(Fraccion frac1, Fraccion frac2){
        Fraccion resultado = new Fraccion();

        resultado.setNumerador(frac1.getNumerador()* frac2.getNumerador()- frac2.getNumerador()* frac1.getDenominador());
        resultado.setDenominador(frac1.getDenominador()* frac2.getDenominador());

        return resultado;
    }

    public Fraccion resta(Fraccion frac1, int num){
        Fraccion resultado = new Fraccion();
        Fraccion fracAux = new Fraccion();
        fracAux.setNumerador(num);
        fracAux.setDenominador(1);

        resultado.setNumerador(frac1.getNumerador()* fracAux.getNumerador()- fracAux.getNumerador()* frac1.getDenominador());
        resultado.setDenominador(frac1.getDenominador()* fracAux.getDenominador());

        return resultado;
    }

    public Fraccion multiply(Fraccion a, Fraccion b){
        Fraccion res = new Fraccion();
        res.setNumerador(a.getNumerador()*b.getNumerador());
        res.setDenominador(a.getDenominador()*b.getDenominador());
        return res;
    }
    public Fraccion multiplar(Fraccion a, Fraccion b){
        Fraccion resultado = new Fraccion();
        resultado.setNumerador(a.getNumerador()*b.getNumerador());
        resultado.setDenominador(a.getDenominador()*b.getDenominador());
        return resultado;
    }

    public Fraccion multiplar(Fraccion frac1, int num){
        Fraccion resultado = new Fraccion();
        Fraccion fracAux = new Fraccion();
        fracAux.setNumerador(num);
        fracAux.setDenominador(1);

        resultado.setNumerador(frac1.getNumerador()*fracAux.getNumerador());
        resultado.setDenominador(frac1.getDenominador()*fracAux.getDenominador());
        return resultado;
    }
    public Fraccion dividir(Fraccion frac1, int num){
        Fraccion resultado = new Fraccion();
        Fraccion fracAux = new Fraccion();
        fracAux.setNumerador(num);
        fracAux.setDenominador(1);

        resultado.setNumerador(frac1.getNumerador()*fracAux.getDenominador());
        resultado.setDenominador(frac1.getDenominador()*fracAux.getNumerador());
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
