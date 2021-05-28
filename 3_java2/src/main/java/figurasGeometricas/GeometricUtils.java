package figurasGeometricas;

public class GeometricUtils {

    public static double areaPromedio (FiguraGeometrica arr[]) {

        int sumatoriaArea = 0;

        for (int i = 0; i < arr.length; i++) {
            sumatoriaArea += arr[i].area();
        }

        return (sumatoriaArea/arr.length);
    }
}

/*Crear una clase utilitaria con un método estático: public static double areaPromedio (FiguraGeometrica arr[]),
que calcule y retorne el área promedio de las figuras contenidas en el array. Crear un programa, instanciar un
FiguraGeometrica[], cargarle datos e invocar a areaPromedio para obtener el área promedio. Mostrar el resultado.
*/