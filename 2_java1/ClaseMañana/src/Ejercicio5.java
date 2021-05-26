import java.util.Scanner;

public class Ejercicio5 {

    public static boolean verify(Integer numToVerify, Integer num, int quantityNum){
        int newQuantity = 0;

        while(numToVerify > 9){
            if(numToVerify % 10 == num) newQuantity++;
            numToVerify /= 10;
        }
        if(numToVerify == num) newQuantity++;

        if(newQuantity == quantityNum) return true;
        else return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Que número quieres que aparezca?");
        int num = scanner.nextInt();

        System.out.println("Cuantas veces quieres que aparezca?");
        int quantityNum = scanner.nextInt();

        System.out.println("Cuantos números quieres ver que contengan " + quantityNum + " veces el " + num);
        int quantity = scanner.nextInt();

        int shows = 0;
        int current = num * (int) Math.pow(10, quantityNum - 1);
        while(shows < quantity){
            if(verify(current, num, quantityNum)){
                shows++;
                System.out.print(current);
                if(shows < quantity) System.out.print(", ");
            }
            current++;
        }
    }
}
