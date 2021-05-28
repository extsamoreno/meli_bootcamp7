package Ejercicio8;

public abstract class FiguraGeometrica {
    public abstract double area();

    public void imprimirArea(){
        System.out.println("Area de la figura "+area());
    }
    @Override
    public String toString() {
        return super.toString();
    }

    public static double areaPromedio(FiguraGeometrica arr[]){
        double sum=0;
        for(FiguraGeometrica f: arr){
            sum+=f.area();
        }
        return sum/arr.length;
    }

}
