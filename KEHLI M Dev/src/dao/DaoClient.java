package dao;

import model.Client;
import model.modelException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class DaoClient {
    public static ArrayList<Client> findAll() throws SQLException, IOException, modelException, daoException {
        Connection connection = Connexion.getInstance();
        Statement statement = null;
        String query =
                "SELECT ID_CLIENT, CHIFFREAFFAIRE_CLIENT, RAISONSOCIAL_SOCIETE,NUMERORUE_SOCIETE,NOMRUE_SOCIETE," +
                        "VILLE_SOCIETE,CODEPOSTAL_SOCIETE, TELEPHONE_SOCIETE, ADRESSEMAIL_SOCIETE, COMMENTAIRE_SOCIETE,"
                        + "NBREMPLOYE_CLIENT FROM CLIENT ORDER BY RAISONSOCIAL_SOCIETE ASC; ";

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

        if (statement!=null){
            statement.close();
        }
        return clients;
    }

    public static ArrayList<String> findAllRS() throws SQLException, IOException, modelException, daoException {
        Connection connection = Connexion.getInstance();
        Statement statement = null;
        String query =
                "SELECT RAISONSOCIAL_SOCIETE,NUMERORUE_SOCIETE,NOMRUE_SOCIETE," +
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
        ArrayList<String> raisonSocials = new ArrayList<>();
        while (rs.next()) {
            String raisonsocialSociete = rs.getString("RAISONSOCIAL_SOCIETE");

            raisonSocials.add(raisonsocialSociete);
        }

        if (statement!=null){
            statement.close();
        }
        return raisonSocials;
    }


    public static Client findByName(String name) throws SQLException, IOException, modelException, daoException {
        Connection connection = Connexion.getInstance();
        PreparedStatement statement = null;
        String query =
                "SELECT ID_CLIENT, CHIFFREAFFAIRE_CLIENT, RAISONSOCIAL_SOCIETE,NUMERORUE_SOCIETE,NOMRUE_SOCIETE," +
                        "VILLE_SOCIETE,CODEPOSTAL_SOCIETE, TELEPHONE_SOCIETE, ADRESSEMAIL_SOCIETE, COMMENTAIRE_SOCIETE,"
                        + "NBREMPLOYE_CLIENT FROM CLIENT WHERE RAISONSOCIAL_SOCIETE = ?";

        statement = connection.prepareStatement(query);
        statement.setString(1,name);
        ResultSet rs = statement.executeQuery();
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
                return new Client(id,raisonsocialSociete,numerorueSociete,
                        nomrueSociete,codepostalSociete,
                        villeSociete,telephoneSociete,adressemailSociete,
                        commentaireSociete,chiffreAffaire,nbremployeClient);
            } else {
                throw new daoException("find by name error");
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
    }

    public static void update(Client client) throws SQLException, IOException, daoException {
        Connection connection = Connexion.getInstance();
        String query = "UPDATE CLIENT " +
                "   SET CHIFFREAFFAIRE_CLIENT = ?" +
                ",RAISONSOCIAL_SOCIETE = ?" +
                ",NUMERORUE_SOCIETE = ?" +
                ",NOMRUE_SOCIETE = ?" +
                ",VILLE_SOCIETE = ?" +
                ",CODEPOSTAL_SOCIETE = ?" +
                ",TELEPHONE_SOCIETE = ?" +
                ",ADRESSEMAIL_SOCIETE = ?" +
                ",COMMENTAIRE_SOCIETE = ?" +
                ",NBREMPLOYE_CLIENT = ?" +
                " WHERE ID_CLIENT =  ?";

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
        statement.setInt(11,client.getIdentifiant());
        int lignesModifiees = statement.executeUpdate();
        if (lignesModifiees <= 0){
            throw new daoException("erreur d'update Client");
        }
        statement.close();

    }

    public static void delete(int id) throws SQLException, IOException, daoException {
        Connection connection = Connexion.getInstance();
        String query = "DELETE FROM CLIENT WHERE ID_CLIENT = ?";
        if (connection == null) {
            throw new daoException("La connexion à la base de données a échoué");
        }
        PreparedStatement statement = connection.prepareStatement(query);
        if (statement == null) {
            throw new daoException("create : Impossible de créer le statement pour exécuter la requête");
        }
        statement.setInt(1,id);
        statement.executeUpdate();
        statement.close();
    }
}
