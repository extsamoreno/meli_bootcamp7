package com.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class StringUtil {
    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        String arrs [] = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrs[i]=String.valueOf(arr[i]);
        }
        return arrs;
    }



    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        int leng =arr[0].length();
        for(String x:arr){
            if(x.length() > leng){
                leng=x.length();
            }

        }
        return leng;
    }


    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[],char c)
    {
        int max =maxLength(arr);
        int indice =0;
        for(String x : arr){
            x=lpad(x,max,c);
            arr[indice]=x;
            indice++;
        }
    }
    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s,int n,char c)
    {
        int faltantes =n-s.length();
        if(faltantes>0){
            s=replicate(c,faltantes)+s;
        }
        return s;
    }

    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n)
    {
        String zerostring ="";
        for (int i = 0; i < n; i++) {
            zerostring+=c;

        }
        return zerostring;
    }

    public static String[] hash(String arr[],int pos){
        HashMap<Integer, ArrayList> hm = new HashMap<>();
        for (int j = 0; j <= 9; j++) {
            ArrayList<String> al = new ArrayList();
            for (int i = 0; i < arr.length; i++) {
                if(arr[i].charAt(pos)==(char)(j +'0')){
                    al.add(arr[i].toString());
                }
            }
            hm.put(j, al);

        }
        String b[] = new String[arr.length];
        int contador=0;
        for (int i = 0; i < hm.size(); i++) {

            if(hm.get(i).size()!=0){
                for (int j = 0; j < hm.get(i).size(); j++) {
                    b[contador]=hm.get(i).get(j).toString();
                    contador=contador+1;
                }
            }
        }
        return b;
    }
    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        int Array [] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Array[i]=Integer.parseInt(arr[i]);
        }
        return Array;
    }

    public static String rpad(String s,int n,char c)
    {
        int faltantes =s.length()-n;
        if(faltantes>0){
            s=s+replicate(c,faltantes);
        }
        return s;
    }

    public static String trim(String s)
    {
        return s.trim();
    }

    public static String ltrim(String s)
    {
        return s.replaceAll("^[　 ]+", "");
    }
    public static String rtrim(String s)
    {
        return s.replaceAll("\\s*$","");
    }
    public static int indexOfN(String s,char c,int n){

        return s.indexOf(c,n);
    }
}
