public class Fraccion
{
    private int numerador;
    private int denominador;

    public static void main (String[] args)
    {
        // Se crean 4 fracciones
        Fraccion f1 = new Fraccion(1, 2);
        Fraccion f2 = new Fraccion(2, 3);
        Fraccion f3 = new Fraccion();
        Fraccion f4 = new Fraccion(4);

        Fraccion suma = f1.sumar(f2);
        Fraccion resta = f1.restar(f3);
        Fraccion multiplicacion = f1.multiplicar(f4);
        Fraccion division = f1.dividir(f2);

        System.out.println(f1 + " + " + f2 + " = " + suma);
        System.out.println(f1 + " - " + f3 + " = " + resta);
        System.out.println(f1 + " * " + f4 + " = " + multiplicacion);
        System.out.println(f1 + " / " + f2 + " = " + division);
    }

    //region Constructor
    public Fraccion()
    {
        this.numerador = 0;
        this.denominador = 1;
    }

    public Fraccion(int num)
    {
        this.numerador = num;
        this.denominador = 1;
    }

    public Fraccion(int num, int den)
    {
        this.numerador = num;
        if(den==0)
        {
            den = 1;
        }
        this.denominador = den;
        simplificar();
    }
    //endregion

    //region methods

    public Fraccion sumar(Fraccion f)
    {
        Fraccion aux = new Fraccion();
        aux.numerador = this.numerador * f.denominador + this.denominador * f.numerador;
        aux.denominador = this.denominador * f.denominador;
        aux.simplificar();
        return aux;
    }

    public Fraccion restar(Fraccion f)
    {
        Fraccion aux = new Fraccion();
        aux.numerador = this.numerador * f.denominador - this.denominador * f.numerador;
        aux.denominador = this.denominador * f.denominador;
        aux.simplificar();
        return aux;
    }

    public Fraccion multiplicar(Fraccion f)
    {
        Fraccion aux = new Fraccion();
        aux.numerador = this.numerador * f.numerador;
        aux.denominador = this.denominador * f.denominador;
        aux.simplificar();
        return aux;
    }

    public Fraccion dividir(Fraccion f)
    {
        Fraccion aux = new Fraccion();
        aux.numerador = this.numerador * f.denominador;
        aux.denominador = this.denominador * f.numerador;
        aux.simplificar();
        return aux;
    }

    @Override
    public String toString()
    {
        simplificar();
        return numerador + "/" + denominador;
    }

    private void simplificar()
    {
        int n = mcd(); // minimo comun divisor
        numerador = numerador / n;
        denominador = denominador / n;
    }

    private int mcd()
    {
        int u = Math.abs(numerador);
        int v = Math.abs(denominador);
        int r;

        if (v == 0)
        {
            return u;
        }

        while (v != 0)
        {
            r = u % v;
            u = v;
            v = r;
        }

        return u;
    }
    //endregion

    //region getter y Setters
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
    //endregion
}
