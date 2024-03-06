package utilities;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class DateFormat {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String formatDate(LocalDate date) {

        return date.format(FORMATTER);
    }
    public static LocalDate toLocalDate (String date) {

        return LocalDate.parse(date,FORMATTER);
    }

}


