
public class Operations {
    

    public static boolean isPrime(int number){
        int multiplos = 0;
        for (int i = 1; i < number; i++) {

            if(number%i == 0){
                multiplos++;
            }
            
        }

        return (multiplos == 1);
        
    }

    public static boolean isMultiplier(int number, int multiplier){

        return (number%multiplier == 0);
    }

    public static boolean isPair(int number){

        return isMultiplier(number, 2);
    }
}
