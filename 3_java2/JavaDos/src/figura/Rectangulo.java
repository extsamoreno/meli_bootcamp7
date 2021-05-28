package figura;

public class Rectangulo extends FiguraGeometrica {
  private double base, altura;

  public Rectangulo(double base, double altura) {
    this.base = base;
    this.altura = altura;
  }

  @Override
  public double area() {
    this.superficie = this.base * this.altura;
    return this.superficie;
  }
}