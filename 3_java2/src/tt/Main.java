package tt;

public class Main {

    public static void main(String[] args) {
        Password pswd = new Password("pass");

        try {
            pswd.setValue("pass");
            System.out.println("ok");
        } catch (IllegalArgumentException ex) {
            System.out.println("error " + ex.getMessage());
        }

        PasswordFuerte strong = new PasswordFuerte();

        try {
            strong.setValue("Ho?5asds");
            System.out.println("ok");
        } catch (IllegalArgumentException ex) {
            System.out.println("error " + ex.getMessage());
        }

        PasswordMedio medium = new PasswordMedio();

        try {
            medium.setValue("a1%asdert");
            System.out.println("ok");
        } catch (IllegalArgumentException ex) {
            System.out.println("error " + ex.getMessage());
        }

        PasswordSimple weak = new PasswordSimple();

        try {
            weak.setValue("asdf1234");
            System.out.println("ok");
        } catch (IllegalArgumentException ex) {
            System.out.println("error " + ex.getMessage());
        }

        FiguraGeometrica[] arr;
        arr = new FiguraGeometrica[3];
        arr[0] = new Circulo(10);
        arr[1] = new Triangulo(10, 5);
        arr[2] = new Rectangulo(10, 10);

        double areaPromedio = Utils.areaPromedio(arr);
        System.out.println(areaPromedio);
    }
}
