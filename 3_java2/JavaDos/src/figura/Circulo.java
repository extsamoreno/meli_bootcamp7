package figura;

public class Circulo extends FiguraGeometrica {
  private int radio;
  private final double pi = 3.14159265359;

  public Circulo(int radio) {
    this.radio = radio;
  }

  @Override
  public double area(){
    this.superficie = pi * (Math.pow(this.radio, 2));
    return this.superficie;
  }
}
