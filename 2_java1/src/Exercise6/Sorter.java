package Exercise6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sorter {

    public static HashMap<Integer, ArrayList<String>> radix(int[] arr){
        StringUtils utils = new StringUtils();
        String[] parser = utils.parserIntList(arr);
        int longest = utils.getLongestNumber(arr);
        String[] arrWithZeros = utils.addZero(parser,longest);
        HashMap<Integer, ArrayList<String>> containers = utils.getContainers();
        for(String number : arrWithZeros){
            ArrayList<String> numbers = containers.get(Integer.parseInt(number.charAt(longest-1)+""));
            numbers.add(number);
        }
        int positionLast = longest;
        while(--positionLast>=0){
            HashMap<Integer, ArrayList<String>> containersAux = utils.getContainers();
            for(Integer key : containers.keySet()){
                ArrayList<String> numbers = containers.get(key);//containers.get(positionLast);
                if(numbers.size()>0){

                    for(String number : numbers){

                        //if(Integer.parseInt(number.charAt(positionLast)+"")==key){
                            ArrayList<String> correctNewPosition = containersAux.get(Integer.parseInt(number.charAt(positionLast)+""));//positionLast);
                            correctNewPosition.add(number);
                        //}
                    }
                }
            }

            containers = (HashMap<Integer, ArrayList<String>>)containersAux.clone();
        }
        return containers;

    }
    public static void main(String[] args) {
        int arr[] = {4,28,132,3,61,5};
        HashMap<Integer, ArrayList<String>> containers = radix(arr);
        for(Integer key : containers.keySet()){
            System.out.println("Key " + key);
            for(String number : containers.get(key)){
                System.out.println("Values " + number);
            }
        }
    }
}
