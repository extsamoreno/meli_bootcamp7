package com.Desafio1.SocialMeli.Utils;

public class Utils {
    // Metodo que retorna la forma de comparar dos Comparable segun el criterio elegido por el usuario
    public static int sortBy(Comparable a, Comparable b, String sortBy) {
        int result = 0;
        if(sortBy == null) return result;
        else if(sortBy.equals("name_asc") || sortBy.equals("date_asc")){
            result = a.compareTo(b);
        } else if(sortBy.equals("name_desc") || sortBy.equals("date_desc")){
            result = b.compareTo(a);
        }
        return result;
    }
}
