public class Triangulo extends FiguraGeometrica{
    private int base;
    private int altura;

   //contructores
    public Triangulo() {
    }

    public Triangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }


    //get and set
    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }


    @Override
    public double area() {
        return (float)(this.getBase()*this.getAltura())/2;
    }


}
