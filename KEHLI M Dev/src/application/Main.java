package application;

import controleur.ControleurAccueil;
import utilities.FormatLog;
import utilities.MyLogg;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;

/**
 * La classe Main est la classe principale du programme.
 */
public class Main {

    /**
     * Méthode principale du programme.
     *
     * @param args Les arguments en ligne de commande
     * @throws IOException Si une exception d'entrée/sortie survient.
     */
    public static void main(String[] args) throws IOException {
        // Configuration du fichier de log
        FileHandler fl = new FileHandler("FichierLog.log", true);
        fl.setFormatter(new FormatLog());
        MyLogg.LOGGER.setUseParentHandlers(false);
        MyLogg.LOGGER.addHandler(fl);

        // Log du début du programme
        MyLogg.LOGGER.log(Level.INFO, "Début du programme");

        // Initialisation du contrôleur de l'accueil
        ControleurAccueil.init();

        // Log de la fin du programme
        MyLogg.LOGGER.log(Level.INFO, "Fin du programme");
    }
}
