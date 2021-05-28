public abstract class FiguraGeometrica {
    public abstract double area();

    public String toString(){
        return "El area es: "+area();
    }

    public static double areaPromedio (FiguraGeometrica arr[]){
        double sumaAreas = 0;
        for (FiguraGeometrica f : arr){
            sumaAreas+= f.area();
        }
        return sumaAreas;
    }

    public static void main(String[] args) {
        Triangulo t = new Triangulo(2,2);
        Rectangulo r = new Rectangulo(2,2);
        Circulo c = new Circulo(2);

        FiguraGeometrica arr[] = new FiguraGeometrica[3];
        arr[0]=t;
        arr[1]=r;
        arr[2]=c;

        double res = FiguraGeometrica.areaPromedio(arr);
        System.out.println(res);
    }

}
