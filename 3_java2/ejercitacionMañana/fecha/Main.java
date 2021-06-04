package fecha;

public class Main {
    public static void main(String[] args) {
        Fecha f1 = new Fecha(20, 03, 2020);
        Fecha f2 = new Fecha(222, 56, 2030);

        System.out.println(f1);
        System.out.println(f2);
        f1.agregarDia();
        System.out.println(f1);
    }
}
