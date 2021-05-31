package ejercicioTarde;

import com.ejercicioMañana.Contador;
import com.ejercicioMañana.CuentaCorriente;
import com.ejercicioMañana.Libro;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Ejercicio tarde Password");

        var pass1 = new PasswordFuerte("passQQ");
        var pass2 = new PasswordIntermedia("passQQ");
        var pass3 = new PasswordSimple("passQQ");

        var figGeo = new FiguraGeometrica[]{new Circulo(2),new Rectangulo(2,1),new Triangulo(2,1)};
        System.out.println(FiguraGeometricaUtils.areaPromedio(figGeo));



    }
}
