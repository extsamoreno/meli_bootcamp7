package ejercicios;

class Circulo extends FiguraGeometrica
{
    private double radio;
    public Circulo(int r){ this.radio=r; }
    @Override
    public double area()
    {
        return Math.PI*Math.pow(radio,2); // PI*radio al cuadrado
    }

}