import ejercicio1.*;
import ejercicio2.*;

public class Main {

    public static void main(String[] args) throws Exception {

        // Ejercicio Password
        PasswordSimple pwd1 = new PasswordSimple();
        pwd1.setValue("soyunpassword");

        /**
        PasswordIntermedia pwd2 = new PasswordIntermedia();
        pwd2.setValue("soyunpassword");

        PasswordFuerte pwd3 = new PasswordFuerte();
        pwd3.setValue("soyunpassword");
         **/

        // Crear arreglo de figuras
        FiguraGeometrica fgs[] = new FiguraGeometrica[3];
        fgs[0] = new Circulo(2);
        fgs[1] = new Triangulo(2, 1);
        fgs[2] = new Rectangulo(2, 1);

        System.out.println("Area promedio de figuras: "+FigureUtil.areaPromedio(fgs));
        
    }
}
