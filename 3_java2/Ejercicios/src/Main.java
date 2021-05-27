public class Main {

    public static void main(String[] args) {

        Fraccion fr1 = new Fraccion(2,5);
        Fraccion fr2 = new Fraccion(3,4);
        System.out.println(fr1.sumar(fr2));
        System.out.println(fr1.sumar(2));
        System.out.println(fr1.restar(fr2));
        System.out.println(fr1.restar(4));
        System.out.println(fr1.multiplicar(fr2));
        System.out.println(fr1.multiplicar(6));
        System.out.println(fr1.dividir(fr2));
        System.out.println(fr1.multiplicar(5));
    }
}
