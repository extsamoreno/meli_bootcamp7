package practicaTM;

public class Main {


    public static void main(String[] args) {
        Fraccion fr1 = new Fraccion(4, 5);
        Fraccion fr2 = new Fraccion(6, 8);
        Fraccion sumaF = fr1.sumar(fr2);
        Fraccion sumaE = fr1.sumar(3);
        Fraccion restaF = fr1.restar(fr2);
        Fraccion restaE = fr1.restar(3);
        Fraccion multF = fr1.multiplicar(fr2);
        Fraccion multE = fr1.multiplicar(3);
        Fraccion divF = fr1.dividir(fr2);
        Fraccion divE = fr1.dividir(3);

        System.out.println(fr1.getNumerador() + "/" + fr1.getDenominador());
        System.out.println(fr2.getNumerador() + "/" + fr2.getDenominador());
        System.out.println(sumaF.getNumerador() + "/" + sumaF.getDenominador());
        System.out.println(sumaE.getNumerador() + "/" + sumaE.getDenominador());
        System.out.println(restaF.getNumerador() + "/" + restaF.getDenominador());
        System.out.println(restaE.getNumerador() + "/" + restaE.getDenominador());
        System.out.println(multF.getNumerador() + "/" + multF.getDenominador());
        System.out.println(multE.getNumerador() + "/" + multE.getDenominador());
        System.out.println(divF.getNumerador() + "/" + divF.getDenominador());
        System.out.println(divE.getNumerador() + "/" + divE.getDenominador());


    }
}
