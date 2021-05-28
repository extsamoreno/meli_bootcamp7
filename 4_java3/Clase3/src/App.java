public class App {

    public static void main(String[] args) {
	// write your code here
        Celular c1 = new Celular(7,"111111","modelo 1");
        Celular c2 = new Celular(34, "111111","modelo 1");
        Celular c4 = new Celular(17, "111111","modelo 1");
        Celular c3 = new Celular(24, "111111","modelo 1");
            
        Celular[] arr = {c1, c2, c3, c4};
        
        SortUtil.ordenar(arr);

        for( Celular x: arr){

            System.out.println("año = " + x.getAño());
        }
    }
}