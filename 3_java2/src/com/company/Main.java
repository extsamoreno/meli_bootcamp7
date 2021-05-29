package com.company;

public class Main {

    public static void main(String[] args) throws Exception {

        //String password = "Pepe123456.";
        //Password pass = new Password( "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[–_.]).{8,20}");
       //pass.setPassword(password);

        GeometricFigure arr[] = new GeometricFigure[3];
        arr[0] = new Circle(5);
        arr[1] = new Square(8);
        arr[2] = new Rectangle(3,7);

        double areaPromedio = Utils.areaPromedio(arr);
        System.out.println(areaPromedio);
    }
}
