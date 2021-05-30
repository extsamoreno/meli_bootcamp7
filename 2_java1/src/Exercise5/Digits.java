package Exercise5;

import java.util.ArrayList;
import java.util.List;

public class Digits {
    public static List<String> getMixer(int amount, int repetitions, int digit){
        List<String> resultList = new ArrayList<String>();
        int initial = 0;
        //StringBuffer repetitionsWithDigit = new StringBuffer(String.valueOf(digit).repeat(repetitions));
        for(int position=0;position<=repetitions;position++){
            for(int value=0;value<digit;value++) {
                StringBuffer repetitionsWithDigit = new StringBuffer(String.valueOf(digit).repeat(repetitions));
                if (resultList.size() < amount) {
                    resultList.add(repetitionsWithDigit.insert(position,value).toString());
                } else
                    continue;
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<String> mixes = getMixer(5,2,3);
        for(String word : mixes){
            System.out.println(word);
        }
    }
}
