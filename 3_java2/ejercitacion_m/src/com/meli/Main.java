package com.meli;

public class Main {
    public static void main(String[] args) throws Exception {
        //Cuenta corriente
        CuentaCorriente cuenta = new CuentaCorriente(3000);
        CuentaCorriente cuentaReceptora = new CuentaCorriente(150.39);
        System.out.println(cuenta.getSaldo());
        cuenta.ingreso(3500.63);
        System.out.println(cuenta.getSaldo());
        cuenta.transferencia(2300, cuentaReceptora);
        System.out.println(cuenta.getSaldo());

        System.out.println();

        //Contador
        Contador contador = new Contador(10);
        contador.incrementar();
        System.out.println(contador.getCont());
        contador.decrementar();
        contador.decrementar();
        System.out.println(contador.getCont());

        System.out.println();

        //Libro
        Libro libro = new Libro("Harry Potter", "Rowling, J. K.", "9780545582889", false);
        System.out.println(libro);

        System.out.println();

        //Fraccion
        Fraccion fr1 = new Fraccion(4,5);
        Fraccion fr2 = new Fraccion(6,8);
        System.out.println(fr1.sumar(fr2));
        System.out.println(fr1.sumar(3));
        System.out.println(fr1.restar(fr2));
        System.out.println(fr1.restar(3));
        System.out.println(fr1.multiplicar(fr2));
        System.out.println(fr1.multiplicar(3));
        System.out.println(fr1.dividir(fr2));
        System.out.println(fr1.multiplicar(3));

        System.out.println();

        //Fecha
        try {
            Fecha fecha = new Fecha(5,5,2021);
            fecha.addDay();
            System.out.println(fecha);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println();

        //StringUtil
        String str = "123";
        str = StringUtil.rpad(str,'0', 5);

        String str1 = "    Hola";
        str1 = StringUtil.ltrim(str1);

        String str2 = "Hola    ";
        str2 = StringUtil.rtrim(str2);

        String str3 = "    Chau    ";
        str3 = StringUtil.trim(str3);

        String str4 = "John|Paul|George|Ringo";
        int index = StringUtil.indexOfN(str4,'|',2);

        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(index);
    }
}
