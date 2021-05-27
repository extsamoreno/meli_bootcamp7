package practicaTM;

public class Main {


    public static void main(String[] args) {
        Fraccion fr1 = new Fraccion(4, 5);
        Fraccion fr2 = new Fraccion(6, 8);
        Fraccion sumaF = fr1.sumar(fr2);
        Fraccion sumaE = fr1.sumar(3);
        Fraccion restaF = fr1.restar(fr2);
        Fraccion restaE = fr1.restar(3);

        System.out.println(fr1.getNumerador() + "/" + fr1.getDenominador());
        System.out.println(fr2.getNumerador() + "/" + fr2.getDenominador());
        System.out.println(sumaF.getNumerador() + "/" + sumaF.getDenominador());
        System.out.println(sumaE.getNumerador() + "/" + sumaE.getDenominador());
        System.out.println(restaF.getNumerador() + "/" + restaF.getDenominador());
        System.out.println(restaE.getNumerador() + "/" + restaE.getDenominador());
//        System.out.println(rtdo1.getNumerador() + "/" + rtdo1.getDenominador());


    }
}
