package dao;

import utilities.MyLogg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;

public class Connexion {
    private static Connection connexion;

    public static void MyConnexion() throws SQLException, IOException {
        // Informations de connexion
        Properties dataProperties = new Properties();
        File fichier = new File("ddb.properties");
        FileInputStream inputStream = new FileInputStream(fichier);
        dataProperties.load(inputStream);
        String url = dataProperties.getProperty("url");
        // Connexion à la base de données
        connexion = DriverManager.getConnection(url);

        // Fermer la connexion lorsque vous avez terminé
        // connexion.close();
    }

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
                        MyLogg.LOGGER.info("Bdd fermée");
                        connexion.close();
                    } catch (SQLException e) {
                        MyLogg.LOGGER.log(Level.SEVERE, e.getMessage());
                    }
                }
            }
        });
    }
}
