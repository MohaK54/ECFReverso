package dao;

import model.Client;
import model.ListeClient;
import model.modelException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoClient {
    public static ArrayList findAll() throws SQLException {
        Connection connection = new Connexion().getInstance();
        Statement statement = null;
        String query =
                "SELECT ID_CLIENT, CHIFFREAFFAIRE_CLIENT, RAISONSOCIAL_SOCIETE,NUMERORUE_SOCIETE,NOMRUE_SOCIETE," +
                        "VILLE_SOCIETE,CODEPOSTAL_SOCIETE, TELEPHONE_SOCIETE, ADRESSEMAIL_SOCIETE, COMMENTAIRE_SOCIETE,"
                        + "NBREMPLOYE_CLIENT FROM CLIENT";
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                int id = rs.getInt("ID_CLIENT");
                double chiffreAffaire = rs.getDouble("CHIFFREAFFAIRE_CLIENT");
                String raisonsocialSociete = rs.getString("RAISONSOCIAL_SOCIETE");
                String numerorueSociete = rs.getString("NUMERORUE_SOCIETE");
                String nomrueSociete = rs.getString("NOMRUE_SOCIETE");
                String villeSociete = rs.getString("VILLE_SOCIETE");
                String codepostalSociete = rs.getString("CODEPOSTAL_SOCIETE");
                String telephoneSociete = rs.getString("TELEPHONE_SOCIETE");
                String adressemailSociete = rs.getString("ADRESSEMAIL_SOCIETE");
                String commentaireSociete = rs.getString("COMMENTAIRE_SOCIETE");
                int nbremployeClient = rs.getInt("NBREMPLOYE_CLIENT");
                Client client = new Client(id,raisonsocialSociete,numerorueSociete,
                        nomrueSociete,codepostalSociete,
                        villeSociete,telephoneSociete,adressemailSociete,
                        commentaireSociete,chiffreAffaire,nbremployeClient);
                ListeClient.getClients().add(client);
            }
        } catch (modelException e) {
            throw new RuntimeException(e);
        }
        return ListeClient.getClients();
    }
}
