package dao;

import utilities.MyLogg;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;

/**
 * La connexion à la base de données
 */
public class Connexion {
    private static Connection connexion;

    /**
     * Initialise une connexion à la base de données en utilisant les informations du fichier de propriétés.
     *
     * @throws IOException Si une exception d'entrée/sortie survient lors de la lecture du fichier de propriétés.
     */
    public static void MyConnexion() throws IOException {
        // Informations de connexion
        Properties dataProperties = new Properties();
        File fichier = new File("ddb.properties");
        FileInputStream inputStream = new FileInputStream(fichier);
        dataProperties.load(inputStream);
        String url = dataProperties.getProperty("url");
        // Connexion à la base de données
        try {
            connexion = DriverManager.getConnection(url);
        } catch (SQLException sqlException) {
            MyLogg.LOGGER.log(Level.SEVERE, "Connexion échouée : " + sqlException.getMessage());
            System.out.println("Erreur de connexion, veuillez consulter les logs pour plus d'informations.");
        }
    }

    /**
     * Récupère une instance de la connexion à la base de données.
     *
     * @return La connexion à la base de données.
     * @throws SQLException Si une exception SQL survient lors de la connexion.
     * @throws IOException  Si une exception d'entrée/sortie survient lors de la lecture du fichier de propriétés.
     */
    public static Connection getInstance() throws SQLException, IOException {
        if (connexion == null || connexion.isClosed()) {
            MyConnexion();
        }
        return connexion;
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                if (connexion != null) {
                    try {
                        MyLogg.LOGGER.info("Base de données fermée.");
                        connexion.close();
                    } catch (SQLException e) {
                        MyLogg.LOGGER.log(Level.SEVERE, e.getMessage());
                    }
                }
            }
        });
    }
}
