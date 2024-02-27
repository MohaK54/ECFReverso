package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private static Connection connexion;

    public static void MyConnexion() throws SQLException {
        // Informations de connexion
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Reverso;IntegratedSecurity=true;" +
                "encrypt=true;trustServerCertificate=true";

        // Connexion à la base de données
        connexion = DriverManager.getConnection(url);


        // Fermer la connexion lorsque vous avez terminé
        // connexion.close();
    }

    public static Connection getInstance() throws SQLException {
        if (connexion == null || connexion.isClosed()) {
            MyConnexion();
        }
        return connexion;
    }

}
