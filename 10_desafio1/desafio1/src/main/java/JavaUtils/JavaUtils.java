package JavaUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class JavaUtils {

    // Convert Date to LocalDate
    public static LocalDate convertToLocalDate(Date dateToConvert) {
        return LocalDate.ofInstant(dateToConvert.toInstant(), ZoneId.systemDefault());
    }
}
