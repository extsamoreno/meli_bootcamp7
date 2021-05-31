import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        ejercicio1();
        
    }

    private static void ejercicio1() {
        Prenda prenda1= new Prenda("Pantalon Campanero","Soul Train");
        Prenda prenda2= new Prenda("Camisa corta","Gucci");
        List<Prenda> listaDePrendas= new ArrayList<Prenda>();
        listaDePrendas.add(prenda1);
        listaDePrendas.add(prenda2);
        System.out.println("Sus prendas quedaron guardadas con el identificador "+GuardaRopa.guardarPrendas(listaDePrendas));
        Scanner entrada= new Scanner(System.in);
        System.out.print("Ingrese el indentificador de sus prendas: ");
        Integer id= entrada.nextInt();
        System.out.println("Las prendas encontradas en el identificador correspondiente fueron: ");
        for (int i = 0; i < GuardaRopa.devolverPrendas(id).size(); i++) {
            System.out.print(GuardaRopa.devolverPrendas(id).get(i)+"\n");
        }
    }
}
