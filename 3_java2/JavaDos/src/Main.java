import javaDos.Password;
import figura.FiguraGeometrica;
import figura.Circulo;
import figura.Triangulo;
import figura.Rectangulo;
import figura.AreaPromedio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

/*  ---------------------------------------- TT - EJ 1  ----------------------------------------

    HashMap <String, String> pwdLevel = new HashMap<>();
    pwdLevel.put("weak","(?=.*[0-9])(?=.*[a-z]).{8,20}");
    pwdLevel.put("half","(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}");
    pwdLevel.put("strong","^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");

    System.out.print("Ingrese nivel de seguridad de contraseña ( weak / half / strong ): ");
    Scanner sc = new Scanner(System.in);
    String levelChoosed = sc.next();

    System.out.print("Ingrese una contraseña: ");
    String pwdChoosed = sc.next();

    Password pwdInstance = new Password(pwdLevel.get(levelChoosed));
    pwdInstance.setPwd(pwdChoosed);

    ---------------------------------------- TT - EJ 2  ----------------------------------------

    Circulo circulo = new Circulo(2);
    circulo.area();
    System.out.println(circulo);

    Triangulo triangulo = new Triangulo (2, 9);
    triangulo.area();
    System.out.println(triangulo);

    Rectangulo rectangulo = new Rectangulo(10, 21);
    rectangulo.area();
    System.out.println(rectangulo);

    FiguraGeometrica arrFiguras[] = new FiguraGeometrica[3];
    arrFiguras[0] = new Circulo(6);
    arrFiguras[1] = new Rectangulo(2, 1);
    arrFiguras[2] = new Triangulo(4, 6);

    System.out.println(AreaPromedio.areaPromedio(arrFiguras));
 */
    Circulo circulo = new Circulo(2);
    circulo.area();
    System.out.println(circulo);

    Triangulo triangulo = new Triangulo (2, 9);
    triangulo.area();
    System.out.println(triangulo);

    Rectangulo rectangulo = new Rectangulo(10, 21);
    rectangulo.area();
    System.out.println(rectangulo);

    FiguraGeometrica arrFiguras[] = new FiguraGeometrica[3];
    arrFiguras[0] = new Circulo(6);
    arrFiguras[1] = new Rectangulo(2, 1);
    arrFiguras[2] = new Triangulo(4, 6);

    System.out.println(AreaPromedio.areaPromedio(arrFiguras));
  }
}
