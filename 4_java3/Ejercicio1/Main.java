package JavaDay3.Ejercicio1;

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

        Celular ca,cb,cc,cd;
        ca = new Celular(1234, pa);
        cb = new Celular(97234, pb);
        cc = new Celular(310, pc);
        cd = new Celular(4352, pd);

        Celular[] arr2 = {ca,cb,cc,cd};
        SortUtil.ordenar(arr2);
        for(Celular celular: arr2){
            System.out.println(celular.getTitular().getNombre());
            System.out.println(celular.getNumero());
        }


    }
}
