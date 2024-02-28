package dao;

import model.Client;
import model.modelException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DaoClient {
    public static ArrayList findAll() throws SQLException, IOException, modelException, daoException {
        Connection connection = Connexion.getInstance();
        Statement statement = null;
        String query =
                "SELECT ID_CLIENT, CHIFFREAFFAIRE_CLIENT, RAISONSOCIAL_SOCIETE,NUMERORUE_SOCIETE,NOMRUE_SOCIETE," +
                        "VILLE_SOCIETE,CODEPOSTAL_SOCIETE, TELEPHONE_SOCIETE, ADRESSEMAIL_SOCIETE, COMMENTAIRE_SOCIETE,"
                        + "NBREMPLOYE_CLIENT FROM CLIENT";

        if (connection == null) {
            throw new daoException("La connexion à la base de données a échoué");
        }
        statement = connection.createStatement();
        if (statement == null) {
            throw new daoException("Impossible de créer le statement pour exécuter la requête");
        }
        ResultSet rs = statement.executeQuery(query);
        ArrayList<Client> clients = new ArrayList<>();
        while (rs.next()) {
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
            Client client = new Client(id, raisonsocialSociete, numerorueSociete,
                    nomrueSociete, codepostalSociete,
                    villeSociete, telephoneSociete, adressemailSociete,
                    commentaireSociete, chiffreAffaire, nbremployeClient);
            clients.add(client);
        }
        if (connection!=null)
        {
            connection.close();
        }
        if (statement!=null){
            statement.close();
        }
        return clients;
    }


    public static Client findByName(String name) throws SQLException, IOException, modelException, daoException {
        Connection connection = Connexion.getInstance();
        Statement statement = null;
        String query =
                "SELECT ID_CLIENT, CHIFFREAFFAIRE_CLIENT, RAISONSOCIAL_SOCIETE,NUMERORUE_SOCIETE,NOMRUE_SOCIETE," +
                        "VILLE_SOCIETE,CODEPOSTAL_SOCIETE, TELEPHONE_SOCIETE, ADRESSEMAIL_SOCIETE, COMMENTAIRE_SOCIETE,"
                        + "NBREMPLOYE_CLIENT FROM CLIENT WHERE RAISONSOCIAL_SOCIETE = '"+name+"'";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()){
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
                return client;
            } else {
                throw new daoException("find by name error ");
            }
    }

    public static void create(Client client) throws SQLException, IOException, daoException {
        Connection connection = Connexion.getInstance();
        String query = "INSERT INTO CLIENT (CHIFFREAFFAIRE_CLIENT, RAISONSOCIAL_SOCIETE, NUMERORUE_SOCIETE, " +
                "NOMRUE_SOCIETE, VILLE_SOCIETE, CODEPOSTAL_SOCIETE, TELEPHONE_SOCIETE, ADRESSEMAIL_SOCIETE, " +
                "COMMENTAIRE_SOCIETE, NBREMPLOYE_CLIENT) VALUES (?,?,?,?,?,?,?,?,?,?) ";
        if (connection == null) {
            throw new daoException("La connexion à la base de données a échoué");
        }
        PreparedStatement statement = connection.prepareStatement(query);
        if (statement == null) {
            throw new daoException("create : Impossible de créer le statement pour exécuter la requête");
        }
        statement.setDouble(1,client.getChiffreAffaire());
        statement.setString(2,client.getRaisonSociale());
        statement.setString(3,client.getNumeroRue());
        statement.setString(4,client.getNomRue());
        statement.setString(5,client.getVille());
        statement.setString(6,client.getCodePostal());
        statement.setString(7,client.getTelephone());
        statement.setString(8,client.getAdresseMail());
        statement.setString(9,client.getCommentaire());
        statement.setInt(10,client.getNbrEmploye());
        int lignesModifiees = statement.executeUpdate();
        if (lignesModifiees <= 0){
            throw new daoException("erreur d'insert into");
        }
        statement.close();
        connection.close();
    }

    public static void update(Client client)
    {

    }

    public static void delete(Client client)
    {

    }
}
