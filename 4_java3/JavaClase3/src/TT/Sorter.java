package TT;

import java.util.Comparator;

public interface Sorter<T> {
    public <T> void sort(T arr[], Comparator<T> c);
}
