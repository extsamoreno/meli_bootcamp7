package com.meli;

public class Main {

    public static void main(String[] args) {
        Fraccion fr1 = new Fraccion(4,5);
        Fraccion fr2 = new Fraccion(6,8);
        Fraccion rtdo = fr1.sumar(fr2);
        Fraccion rtdo1 = fr1.restar(3);
        System.out.println(rtdo.getNumerador() + "/" + rtdo.getDenominador());
        System.out.println(rtdo1.getNumerador() + "/" + rtdo1.getDenominador());
    }
}
