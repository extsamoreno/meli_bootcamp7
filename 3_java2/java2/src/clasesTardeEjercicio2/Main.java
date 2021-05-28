package clasesTardeEjercicio2;



public class Main {

    public static void main(String[] args) {

        FiguraGeometrica arr[]= new FiguraGeometrica[3];
        Circulo c = new Circulo(8);
        Rectangulo r = new Rectangulo(8,5);
        Triangulo t = new Triangulo(5,3);
        arr[0]= c;
        arr[1]= r;
        arr[2]= t;
        System.out.println(areaPromedio(arr));
    }


    public static double areaPromedio (FiguraGeometrica arr[]){
        double sum= 0;
        for (FiguraGeometrica fg:arr){
            sum += fg.area();
        }
        return sum/arr.length;
    }
}

