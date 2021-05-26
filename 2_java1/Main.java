package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public void ejercicio1(Scanner scanner){

        System.out.println("Ingrese el numero n");
        int numN = scanner.nextInt();

        System.out.println("Resultado:");
        for(int i=0;i<=numN;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }
    public void ejercicio2(Scanner scanner){
        System.out.println("Ingrese el multiplicando");
        int iMultiplicando= scanner.nextInt();
        System.out.println("Ingrese el numero de multiplipos a mostrar");
        int iNumeroMultiplos= scanner.nextInt();

        System.out.println("Resultado:");
        for(int i=1;i<=iNumeroMultiplos;i++){
            System.out.println(iMultiplicando*i);
        }
    }
    public void ejercicio3(Scanner scanner, int iNumero){
        if(iNumero==0) {
            System.out.println("Ingrese el numero a evaluar");
             iNumero= scanner.nextInt();
        }
        int contador = 2;

            for(int i=contador;i<iNumero;i++){
                if(iNumero%i==0){
                    contador++;
                }
            }

        if(contador==2){
            System.out.println("El numero "+iNumero+" es primo.");
        }else{
            System.out.println("El numero "+iNumero+" no es primo.");
        }
    }

    public void ejercicio4(Scanner scanner) {
        System.out.println("Ingrese la cantidad de numeros a evaluar");
        int iNumero = scanner.nextInt();
        for (int i=2;i<=iNumero;i++) {
            ejercicio3(scanner,i);
        }
    }
    public void ejercicio5(Scanner scanner) {
        System.out.println("Ingrese la cantidad de numeros a mostrar");
        int iCantNumeros = scanner.nextInt();
        List<Integer> listaNumeros = new ArrayList();
        System.out.println("Ingrese la cantidad de digitos repetidos que debe tener");
        int iCantDigitos = scanner.nextInt();
        System.out.println("Ingrese el digito que debe contener");
        int iDigito = scanner.nextInt();

        int inicio =0;
        String inicioString ="";
        do{
            inicioString = Integer.toString(inicio);
            List<Character> list = inicioString.chars()
                                   .mapToObj(c -> (char) c)
                                   .collect(Collectors.toList());
            int contador =  (int) list.stream().filter(i-> i==Character.forDigit(iDigito, 10)).count();

            if(contador==iCantDigitos){
                listaNumeros.add(inicio);
            }
            inicio++;
        }while(!(listaNumeros.size()==iCantNumeros));

        System.out.println("Resultado: ");
        listaNumeros.forEach(System.out::println);
    }
    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        Main m = new Main();
        //m.ejercicio1(scanner);
        //m.ejercicio2(scanner);
        //m.ejercicio3(scanner,0);
        //m.ejercicio4(scanner);
        m.ejercicio5(scanner);
    }
}
