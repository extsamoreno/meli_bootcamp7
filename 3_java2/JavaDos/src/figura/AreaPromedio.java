package figura;

public class AreaPromedio {
  public static double areaPromedio(FiguraGeometrica arr[]){
    double superficie = 0;


    for (FiguraGeometrica fig : arr) {
      superficie += fig.area();
    }

    return superficie/arr.length;
  }
}
