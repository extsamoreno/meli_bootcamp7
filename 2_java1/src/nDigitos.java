import java.util.Scanner;

public class nDigitos {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Ingrese n: ");
        int n= sc.nextInt();
        System.out.print("Ingrese m: ");
        int m= sc.nextInt();
        System.out.print("Ingrese d: ");
        int d= sc.nextInt();

        int i=0;
        int cont =0;
        do{
            int temp=cont;
            int numero=0;
            while (temp!=0){
                if(temp%10==d){
                    numero++;
                }
                temp/=10;
            }
            if(numero==2){
                System.out.println(cont);
                i++;
            }
            cont++;
        }while(i<n);
    }
}
