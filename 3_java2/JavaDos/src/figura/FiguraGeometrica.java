package figura;



public abstract class FiguraGeometrica {
  protected double superficie;
  public abstract double area();

  @Override
  public String toString() {
    return "El área total de la figura es: " + area();
  }
}
