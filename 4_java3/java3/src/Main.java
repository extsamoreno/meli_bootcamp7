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


    }
}
