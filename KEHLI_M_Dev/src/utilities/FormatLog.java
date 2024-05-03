package utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * Cette classe fournit un format personnalisé pour les logs.
 */
public class FormatLog extends Formatter {

    /**
     * Formate un enregistrement de log.
     *
     * @param record L'enregistrement de log à formater.
     * @return Une chaîne représentant l'enregistrement de log formaté.
     */
    public String format(LogRecord record) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        return format.format(new Date()) +
                " Niveau : " +
                record.getLevel() +
                " / Message : " +
                record.getMessage() +
                " / Méthode : " +
                record.getSourceMethodName() +
                " / Classe : " +
                record.getSourceClassName() +
                "\n";
    }
}
