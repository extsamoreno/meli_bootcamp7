
public class Operations {
    

    public static boolean isPrime(int number){
        int multiplos = 0;
        for (int i = 1; i < number; i++) {

            if(isMultiplier(number,i)){
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

    public static int isContained(int container, int number){
        int counter = 0;
        Integer integer = new Integer(container);
        String containerString = integer.toString();

        for (int i = 0; i < containerString.length(); i++) {

            if(Character.getNumericValue(containerString.charAt(i)) == number){
                counter++;
            }
            
        }
        
        return counter;
    }

    public static boolean isContainedManyTimes(int container,int number, int times){

        return (isContained(container, number) == times);

    }


}
