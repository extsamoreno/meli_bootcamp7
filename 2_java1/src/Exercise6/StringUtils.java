package Exercise6;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StringUtils {
    public String[] parserIntList(int[] list){
        String[] listReturn = new String[list.length];
        for(int i=0;i<list.length;i++){
            listReturn[i] = String.valueOf(list[i]);
        }
        return listReturn;
    }
    public int getLongestNumber(int[] numbers){
        int longest = 0;
        for(int number : numbers){
            if(String.valueOf(number).length()>longest){
                longest = String.valueOf(number).length();
            }
        }
        return longest;
    }
    public String[] addZero(String[] numbers, int longest) {
        String[] resultWithZeros = new String[numbers.length];
        int position = 0;
        for(String number : numbers){
            int zeroToAdd = longest - number.length();
            while(zeroToAdd>0) {
                number = "0" + number;
                zeroToAdd--;
            }
            resultWithZeros[position] = number;
            position++;
        }
        return resultWithZeros;
    }
    public HashMap<Integer, ArrayList<String>> getContainers() {
        HashMap<Integer, ArrayList<String>> containers = new HashMap<>();
        for(Integer i=0;i<10;i++){
            containers.put(i,new ArrayList<>());
        }
        return containers;
    }

    public void orderByPosition(String[] numbers, int position, List<List<String>> container){
        for(String number : numbers){

        }
    }

}