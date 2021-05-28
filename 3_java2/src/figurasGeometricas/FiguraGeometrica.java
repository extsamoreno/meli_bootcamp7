package figurasGeometricas;

public abstract class FiguraGeometrica {
    public abstract double area();

    @Override
    public String toString() {
        return "Area de figura geometrica: " + this.area();
    }

    public static double areaPromedio(FiguraGeometrica[] arr) {
        double temporal = 0;
        for (int i = 0; i < arr.length; i++) {
            temporal += arr[i].area();
        }
        return temporal / arr.length;
    }
}

