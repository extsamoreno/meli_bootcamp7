import java.util.Scanner;
public class ejercicio3 {
}
        import java.util.Scanner;
public class ejercicio3 {
    public static void main(String[] args) {
        //Programa que te dice si un numero es par o impar
        int numero;
        Scanner reader= new Scanner(System.in);
        System.out.print("Ingrese un numero: ");
        numero=reader.nextInt();
        if ((numero%2)==0)
        {
            System.out.print("El número es par");
        }
        else
        {
            System.out.print("El número es impar");
        }

    }
}