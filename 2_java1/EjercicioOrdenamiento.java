package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class EjercicioOrdenamiento {

    public static String[] ordenar(String[] sArr, int digIndice) {

        ArrayList<Integer> l0 = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        ArrayList<Integer> l3 = new ArrayList<>();
        ArrayList<Integer> l4 = new ArrayList<>();
        ArrayList<Integer> l5 = new ArrayList<>();
        ArrayList<Integer> l6 = new ArrayList<>();
        ArrayList<Integer> l7 = new ArrayList<>();
        ArrayList<Integer> l8 = new ArrayList<>();
        ArrayList<Integer> l9 = new ArrayList<>();

        for(String numString:sArr) {

            char digito = numString.charAt(digIndice);
            int numero = Integer.parseInt(String.valueOf(numString));
            switch (digito) {
                case '0':
                    l0.add(numero);
                    break;
                case '1':
                    l1.add(numero);
                    break;
                case '2':
                    l2.add(numero);
                    break;
                case '3':
                    l3.add(numero);
                    break;
                case '4':
                    l4.add(numero);
                    break;
                case '5':
                    l5.add(numero);
                    break;
                case '6':
                    l6.add(numero);
                    break;
                case '7':
                    l7.add(numero);
                    break;
                case '8':
                    l8.add(numero);
                    break;
                case '9':
                    l9.add(numero);
                    break;
            }
        }

        ArrayList<String> resultArr = new ArrayList<>();;

        rearmarLista(l0,resultArr);
        rearmarLista(l1,resultArr);
        rearmarLista(l2,resultArr);
        rearmarLista(l3,resultArr);
        rearmarLista(l4,resultArr);
        rearmarLista(l5,resultArr);
        rearmarLista(l6,resultArr);
        rearmarLista(l7,resultArr);
        rearmarLista(l8,resultArr);
        rearmarLista(l9,resultArr);

        String[] stringArray = resultArr.toArray(new String[0]);
        return stringArray;

    }

    public static ArrayList<String> rearmarLista(ArrayList<Integer> list, ArrayList<String> sArr){

       int tamanio = list.size();
        for(int i=0;i<tamanio;i++){
            sArr.add(list.get(i).toString());
        }

        return sArr;
    }

    public static String[] toStringArray(int arr[]){
        String[] sArr = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        return sArr;

    }

    public static int maxLength(String sArr[])
    {
        int maxLongitud = 0;

        for(String s : sArr){
            if(s.length()>maxLongitud){
                maxLongitud=s.length();
            }
        }
        return maxLongitud;
    }

    public static String[] lNormalize(String sArr[],int maxLongitud)
    {
        int indice =0;
        for(String s : sArr){
            if(s.length()<maxLongitud){
                for(int i=s.length();i<maxLongitud;i++){
                    s="0"+s;
                }
                sArr[indice]=s;
            }
            indice++;
        }
        return sArr;
    }

    public static void main(String[] args) {

        int iArr[] = {16223,898,13,906,235,23,9,1532,6388,2511,8};

        String[] sArr = toStringArray(iArr);

        int maxLongitud = maxLength(sArr);

        sArr = lNormalize(sArr,maxLongitud);

        for(int i=maxLongitud-1;i>=0;i--){
            sArr = lNormalize(sArr,maxLongitud);
            sArr = ordenar(sArr,i);
        }

        System.out.println(Arrays.toString(sArr));

    }
}
