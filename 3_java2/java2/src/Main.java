package java2.src;

import utils.StringUtil;

public class Main {

    public static void main(String[] args) {
//        Date d= new Date();
//        Fecha f= new Fecha(d);
//        System.out.println(f);
//        f.addDay();
//        System.out.println(f);

        String pruebasUtil= "   asdqwrrefsdfdsgfs qww qweq wdsff ";
        System.out.println(StringUtil.ltrim(pruebasUtil));
        System.out.println(StringUtil.rtrim(pruebasUtil));
        System.out.println(StringUtil.trim(pruebasUtil));
        System.out.println(StringUtil.indexOfN(pruebasUtil,'s',4));
        System.out.println(pruebasUtil.charAt(StringUtil.indexOfN(pruebasUtil,'s',3)));


    }
}

