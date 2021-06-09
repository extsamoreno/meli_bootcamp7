package JavaUtils;

import com.example.desafio1.model.Post;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class JavaUtils {

    // Convert Date to LocalDate
    public static LocalDate convertToLocalDate(Date dateToConvert) {
        return LocalDate.ofInstant(dateToConvert.toInstant(), ZoneId.systemDefault());
    }

    // Order Post byDate ASC
    public static void orderByDateASC(ArrayList posts){
        Comparator<Post> c = (p1, p2) -> p2.getDate().compareTo(p1.getDate());
        posts.sort(c);
    }
}
