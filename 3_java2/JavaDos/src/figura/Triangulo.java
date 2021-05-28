package figura;

public class Triangulo extends FiguraGeometrica {
  private int ladoUno, ladoDos;

  public Triangulo(int ladoUno, int ladoDos) {
    this.ladoUno = ladoUno;
    this.ladoDos = ladoDos;
  }

  @Override
  public double area() {
    this.superficie = this.ladoUno * this.ladoDos /2;
    return this.superficie;
  }
}
