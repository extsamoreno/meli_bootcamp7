public class MainClass {
    public static void main(String[] args) {
        pruebaEj1();
        pruebaEj2();
        pruebaEj3();
        pruebaEj4();
        pruebaEj5();
        pruebaEj6();
    }

    private static void pruebaEj6() {
        String s= "     hola mundo     ";
        System.out.println("test"+StringUtil.ltrim(s)+"test");
        System.out.println("test"+StringUtil.rtrim(s)+"test");
        System.out.println("test"+StringUtil.trim(s)+"test");
    }

    private static void pruebaEj5() {
        Fecha f1= new Fecha(2000,11,15);
        Fecha f2= new Fecha(2001, 2, 29);
        System.out.println("Fecha obtenida: "+f1.getFecha().getTime());
        System.out.println("La fecha es correcta? "+f1.esValida());
        System.out.println("Fecha antes de sumar un dia: "+f1.getFecha().getTime());
        f1.addDay();
        System.out.println("Fecha despues de sumar un dia: "+f1.getFecha().getTime());
        System.out.println("Segunda fecha obtenida: "+f2.getFecha().getTime());
        System.out.println("La segunda fecha es correcta? "+f2.esValida());
    }

    private static void pruebaEj4() {
        Fraccion fr1= new Fraccion(13,5);
        Fraccion fr2= new Fraccion(10,17);
        int num=3;

        Fraccion sumaFr= fr1.sumar(fr2);
        System.out.println("Fraccion resultante suma: "+sumaFr.getNum()+"/"+sumaFr.getDen());
        Fraccion restaFr= fr1.restar(fr2);
        System.out.println("Fraccion resultante resta: "+restaFr.getNum()+"/"+restaFr.getDen());
        Fraccion mulFr= fr1.multiplicar(fr2);
        System.out.println("Fraccion resultante multi: "+mulFr.getNum()+"/"+mulFr.getDen());
        Fraccion divFr= fr1.dividir(fr2);
        System.out.println("Fraccion resultante divi: "+divFr.getNum()+"/"+divFr.getDen());

        Fraccion sumaFr2= fr1.sumar(num);
        System.out.println("Fraccion resultante suma2: "+sumaFr2.getNum()+"/"+sumaFr2.getDen());
        Fraccion restaFr2= fr1.restar(num);
        System.out.println("Fraccion resultante resta2: "+restaFr2.getNum()+"/"+restaFr2.getDen());
        Fraccion mulFr2= fr1.multiplicar(num);
        System.out.println("Fraccion resultante multi2: "+mulFr2.getNum()+"/"+mulFr2.getDen());
        Fraccion divFr2= fr1.dividir(num);
        System.out.println("Fraccion resultante div2: "+divFr2.getNum()+"/"+divFr2.getDen());
    }

    private static void pruebaEj3() {
        Libro l1 = new Libro("Hola Mundo",123456789,"Yo");
        System.out.println("Descripcion del libro: "+l1.toString());
        System.out.println("Libro antes de prestar: "+l1.getEstado());
        l1.prestamo();
        System.out.println("Libro despues de prestar: "+l1.getEstado());
        l1.devolucion();
        System.out.println("Libro despues de devolver: "+l1.getEstado());
    }

    private static void pruebaEj2() {
        Contador c1 = new Contador();
        System.out.println("Contador inicial: "+c1.getCounter());
        c1.incrementar();
        System.out.println("Contador al incrementar: "+c1.getCounter());
        c1.decrementar();
        System.out.println("contador al decrementar: "+c1.getCounter());
    }

    private static void pruebaEj1() {
        CuentaCorriente c1 = new CuentaCorriente(100000);
        CuentaCorriente c2 = new CuentaCorriente(200000);
        System.out.println("Saldo actual: "+c1.getSaldo());
        c1.ingreso(500);
        System.out.println("Saldo despues de ingresar: "+c1.getSaldo());
        c1.egreso(500);
        System.out.println("Saldo despues de egresar: "+c1.getSaldo());
        System.out.println("Saldo de la cuenta1: "+c1.getSaldo()+" y la cuenta2: "+c2.getSaldo()+" antes de transferir");
        c1.transferencia(c2, 2000);
        System.out.println("Saldo de la cuenta1: "+c1.getSaldo()+" y la cuenta2: "+c2.getSaldo()+" despues de transferir");
        System.out.println("Saldo de la cuenta1: "+c1.getSaldo()+" y la cuenta2: "+c2.getSaldo()+" antes de reintegrar");
        c1.reintregro(c2,2000);
        System.out.println("Saldo de la cuenta1: "+c1.getSaldo()+" y la cuenta2: "+c2.getSaldo()+" despues de reintegrar");
    }
}
