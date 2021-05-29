package mañana;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Persona pa = new Persona("matias", 33654878, 17);
        Persona pb = new Persona("Leandro", 35644878, 34);
        Persona pc = new Persona("Alexis", 35644878, 17);
        Persona pd = new Persona("Matias2", 35644878, 24);

        Persona[] arr = {pa, pb, pc, pd};

        int a = pb.precedeA(pa);
        System.out.println("a = " + a);

        SortUtil.ordenar(arr);

        for( Persona x: arr){
            System.out.println("x.getnombre() = " + x.getNombre());
            System.out.println("x.getEdad() = " + x.getEdad());
        }

        //==========

        Celular ca = new Celular(21324, "matias");
        Celular cb = new Celular(1323, "Leandro");
        Celular cc = new Celular(432535, "Alexis");
        Celular cd = new Celular(21232, "Matias2");

        Celular[] arrCel = {ca, cb, cc, cd};

        int x = cb.precedeA(ca);
        System.out.println("a = " + x);

        SortUtil.ordenar(arrCel);

        for( Celular z : arrCel){
            System.out.println("tit() = " + z.getTitular());
            System.out.println("num() = " + z.getNumero());
        }


    }
}