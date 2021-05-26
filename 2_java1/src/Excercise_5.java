import java.util.Scanner;


public class Excercise_5 {

    public static boolean passRequeriments(int number,int m, int d){
        int count = 0;
        boolean result = false;
        char[] charsNumber = ("" + number).toCharArray();

        for(int i = 0; i < charsNumber.length; i++){
            int numberASCII = (int) charsNumber[i];
            int numberAux = Character.getNumericValue(numberASCII);
            if( numberAux == d){
                count++;
            }
        }

        if(count == m){
            result = true;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int counter = 1;


        System.out.println("Ingrese los N numeros a mostrar");
        int quantity = scanner.nextInt();

        System.out.println("Ingrese el numero natural a repetirse");
        System.out.println("[1,2,3,4,5,6,7,8,9] debe seleccionar uno de ellos");
        int numberToRepeat = scanner.nextInt();

        System.out.println("Ingrese la cantidad de veces que debe existir el numero: " + numberToRepeat );
        int quantityToRepeat = scanner.nextInt();

        for(int i = 0; i < quantity;){

            while(true){
                if(passRequeriments(counter,quantityToRepeat,numberToRepeat)){
                    System.out.println(counter);
                    counter++;
                    break;
                }
                counter++;
            }
            i++;
        }



    }
}
