package ejercicios;

public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
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


    public int mcm(int num1, int num2){
        int mcm=1;
        int i=2;
        while(i <= num1 || i <= num2)
        {
            if(num1%i==0 || num2%i==0)
            {
                mcm=mcm*i;
                if(num1%i==0) num1=num1/i;
                if(num2%i==0) num2=num2/i;
            }
            else
                i=i+1;
        }
        return mcm;
    };

    public Fraccion suma(Fraccion f){
        int n1 = this.numerador;
        int n2 = f.getNumerador();
        int d1 = this.denominador;
        int d2 = f.getDenominador();
        int d3 = mcm(d1,d2);

        int n3 = ((d3/d1)*n1) + ((d3/d2)*n2);
        Fraccion resultado = new Fraccion(n3,d3);
        return resultado;
    };

    public Fraccion suma(int e){
        Fraccion f = new Fraccion(e,1);
        Fraccion resultado = suma(f);
        return resultado;
    };

    public Fraccion resta(Fraccion f){
        int n1 = this.numerador;
        int n2 = f.getNumerador();
        int d1 = this.denominador;
        int d2 = f.getDenominador();
        int d3 = mcm(d1,d2);

        int n3 = ((d3/d1)*n1) - ((d3/d2)*n2);
        Fraccion resultado = new Fraccion(n3,d3);
        return resultado;
    };

    public Fraccion resta(int e){
        Fraccion f = new Fraccion(e,1);
        Fraccion resultado = resta(f);
        return resultado;
    };

    public Fraccion multiplicacion(Fraccion f){
        int n1 = this.numerador;
        int n2 = f.getNumerador();
        int d1 = this.denominador;
        int d2 = f.getDenominador();
        int n3 = n1*n2;
        int d3 = d1*d2;
        Fraccion resultado = new Fraccion(n3,d3);
        return resultado;
    };

    public Fraccion multiplicacion(int e){
        Fraccion f = new Fraccion(e,1);
        Fraccion resultado = multiplicacion(f);
        return resultado;
    };

    public Fraccion division(Fraccion f){
        int n1 = this.numerador;
        int n2 = f.getNumerador();
        int d1 = this.denominador;
        int d2 = f.getDenominador();
        int n3 = n1*d2;
        int d3 = d1*n2;
        Fraccion resultado = new Fraccion(n3,d3);
        return resultado;
    };

    public Fraccion division(int e){
        Fraccion f = new Fraccion(e,1);
        Fraccion resultado = division(f);
        return resultado;
    };

    public String imprimirFraccion(){
        return this.numerador+ "/" +this.denominador;
    }
}
