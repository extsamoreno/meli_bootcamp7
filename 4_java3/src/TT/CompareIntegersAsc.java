package TT;

import java.util.Comparator;

public class CompareIntegersAsc implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1-o2;
    }
}
