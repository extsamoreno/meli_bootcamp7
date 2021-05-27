public class Fraccion {

    private int numerador;
    private int denominador;

    // Constructores
    public Fraccion() {
    }

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }


    // Metodos
    public Fraccion sumar(Fraccion f2) {

        Fraccion resultado = new Fraccion();

        int nuevoDenominador = mcm(this.denominador, f2.denominador);
        resultado.denominador = (nuevoDenominador);

        int nuevoNumerador1 = nuevoDenominador / this.denominador * this.numerador;
        int nuevoNumerador2 = nuevoDenominador / f2.denominador * f2.numerador;
        resultado.numerador = (nuevoNumerador1 + nuevoNumerador2);

        return resultado;
    }

    public Fraccion sumar(int entero) {

        Fraccion nuevaFraccion = new Fraccion(entero,1);
        return sumar(nuevaFraccion);
    }

    public Fraccion restar(Fraccion f2) {

        Fraccion fr = new Fraccion(-f2.numerador,f2.denominador);
        return sumar(fr);
    }

    public Fraccion restar(int entero) {

        Fraccion nuevaFraccion = new Fraccion(-entero,1);
        return sumar(nuevaFraccion);
    }

    public Fraccion multiplicar(Fraccion f2) {

        Fraccion resultado = new Fraccion();
        resultado.numerador = (this.numerador * f2.numerador);
        resultado.denominador = (this.denominador * f2.denominador);

        return resultado;
    }

    public Fraccion multiplicar(int entero) {

        Fraccion nuevaFraccion = new Fraccion(entero,1);
        return multiplicar(nuevaFraccion);
    }

    public Fraccion dividir(Fraccion f2) {

        Fraccion aux = new Fraccion(f2.denominador,f2.numerador);
        return multiplicar(aux);
    }

    public Fraccion dividir(int entero) {

        Fraccion nuevaFraccion = new Fraccion(entero,1);
        return dividir(nuevaFraccion);
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

    @Override
    public String toString() {
        return "Fraccion: " + denominador + "/" + numerador;
    }

    // Getters y Setters
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
