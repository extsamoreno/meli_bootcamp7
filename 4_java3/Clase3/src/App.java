public class App {

    public static void main(String[] args) {
	// write your code here
        Celular pa = new Celular(7,"111111","modelo 1");
        Celular pb = new Celular(34, "111111","modelo 1");
        Celular pc = new Celular(17, "111111","modelo 1");
        Celular pd = new Celular(24, "111111","modelo 1");
            
        Celular[] arr = {pa, pb, pc, pd};
        
        int a = pb.precedeA(pa);
        System.out.println("a = " + a);
        
        SortUtil.ordenar(arr);

        for( Celular x: arr){

            System.out.println("x.getEdad() = " + x.getAño());
        }
    }
}