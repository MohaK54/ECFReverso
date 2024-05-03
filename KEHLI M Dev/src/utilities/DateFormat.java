package utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Cette classe fournit des méthodes pour formater et convertir des dates.
 */
public class DateFormat {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Formate une date au format "dd/MM/yyyy".
     *
     * @param date La date à formater.
     * @return La date formatée en chaîne de caractères.
     */
    public static String formatDate(LocalDate date) {

        return date.format(FORMATTER);
    }

    /**
     * Convertit une chaîne de caractères en LocalDate en utilisant le format "dd/MM/yyyy".
     *
     * @param date La chaîne de caractères représentant une date.
     * @return La date convertie en LocalDate.
     */
    public static LocalDate toLocalDate(String date) {

        return LocalDate.parse(date, FORMATTER);
    }
}
