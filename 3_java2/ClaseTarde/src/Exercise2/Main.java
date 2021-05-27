package Exercise2;

public class Main {

    public static void main(String[] args) {
        FiguraGeometrica[] arr = new FiguraGeometrica[3];
        arr[0] = new Circulo(3);
        arr[1] = new Rectangulo(2, 4);
        arr[2] = new Triangulo(1, 3);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].area());
        }

        System.out.println();
        System.out.println(Utils.areaPromedio(arr));
    }
}
