package dao;

import model.Client;
import model.Prospect;
import model.modelException;
import utilities.MyLogg;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;

public class DaoProspect {
    public static ArrayList<Prospect> findAll() throws SQLException, IOException, modelException, daoException {
        Connection connection = Connexion.getInstance();
        Statement statement = null;
        String query =
                "SELECT ID_PROSPECT" +
                        ",DATE_PROSPECT" +
                        ",RAISONSOCIAL_SOCIETE" +
                        ",NUMERORUE_SOCIETE" +
                        ",NOMRUE_SOCIETE" +
                        ",VILLE_SOCIETE" +
                        ",CODEPOSTAL_SOCIETE" +
                        ",TELEPHONE_SOCIETE" +
                        ",ADRESSEMAIL_SOCIETE" +
                        ",COMMENTAIRE_SOCIETE" +
                        ",INTERET_PROSPECT" +
                        " FROM PROSPECT" +
                        " ORDER BY RAISONSOCIAL_SOCIETE ASC;";

        if (connection == null) {
            MyLogg.LOGGER.log(Level.SEVERE, "Connexion échoué DaoProspect -> findAll");
            throw new daoException("La connexion à la base de données a échoué");
        }
        statement = connection.createStatement();
        if (statement == null) {
            throw new daoException("Impossible de créer le statement pour exécuter la requête");
        }
        ResultSet rs = statement.executeQuery(query);
        ArrayList<Prospect> prospects = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("ID_PROSPECT");
            Date dateProspect = rs.getDate("DATE_PROSPECT");
            String raisonsocialSociete = rs.getString("RAISONSOCIAL_SOCIETE");
            String numerorueSociete = rs.getString("NUMERORUE_SOCIETE");
            String nomrueSociete = rs.getString("NOMRUE_SOCIETE");
            String villeSociete = rs.getString("VILLE_SOCIETE");
            String codepostalSociete = rs.getString("CODEPOSTAL_SOCIETE");
            String telephoneSociete = rs.getString("TELEPHONE_SOCIETE");
            String adressemailSociete = rs.getString("ADRESSEMAIL_SOCIETE");
            String commentaireSociete = rs.getString("COMMENTAIRE_SOCIETE");
            String interet = rs.getString("INTERET_PROSPECT");
            LocalDate date = dateProspect.toLocalDate();
            Prospect prospect = new Prospect(id,raisonsocialSociete,numerorueSociete,nomrueSociete,codepostalSociete,
                    villeSociete,telephoneSociete,adressemailSociete,commentaireSociete,date,interet);
            prospects.add(prospect);
        }

        if (statement!=null){
            statement.close();
        }
        return prospects;
    }
    public static ArrayList<String> findAllRS() throws SQLException, IOException, modelException, daoException {
        Connection connection = Connexion.getInstance();
        Statement statement = null;
        String query =
                "SELECT RAISONSOCIAL_SOCIETE FROM PROSPECT";

        if (connection == null) {
            MyLogg.LOGGER.log(Level.SEVERE, "Connexion échoué DaoProspect -> findAllRS");
            throw new daoException("La connexion à la base de données a échoué");
        }
        statement = connection.createStatement();
        if (statement == null) {
            throw new daoException("Impossible de créer le statement pour exécuter la requête");
        }
        ResultSet rs = statement.executeQuery(query);
        ArrayList<String> prospects = new ArrayList<>();
        while (rs.next()) {
            String raisonsocialSociete = rs.getString("RAISONSOCIAL_SOCIETE");
            prospects.add(raisonsocialSociete);
        }
        if (statement!=null){
            statement.close();
        }
        return prospects;
    }


    public static Prospect findByName(String name) throws SQLException, IOException, modelException, daoException {
        Connection connection = Connexion.getInstance();
        PreparedStatement statement = null;
        String query =
                "SELECT ID_PROSPECT" +
                        ",DATE_PROSPECT" +
                        ",RAISONSOCIAL_SOCIETE" +
                        ",NUMERORUE_SOCIETE" +
                        ",NOMRUE_SOCIETE" +
                        ",VILLE_SOCIETE" +
                        ",CODEPOSTAL_SOCIETE" +
                        ",TELEPHONE_SOCIETE" +
                        ",ADRESSEMAIL_SOCIETE" +
                        ",COMMENTAIRE_SOCIETE" +
                        ",INTERET_PROSPECT" +
                        " FROM PROSPECT WHERE RAISONSOCIAL_SOCIETE = ?";;
        statement = connection.prepareStatement(query);
        statement.setString(1,name);
        ResultSet rs = statement.executeQuery();
        if (rs.next()){
            int id = rs.getInt("ID_PROSPECT");
            Date dateProspect = rs.getDate("DATE_PROSPECT");
            String raisonsocialSociete = rs.getString("RAISONSOCIAL_SOCIETE");
            String numerorueSociete = rs.getString("NUMERORUE_SOCIETE");
            String nomrueSociete = rs.getString("NOMRUE_SOCIETE");
            String villeSociete = rs.getString("VILLE_SOCIETE");
            String codepostalSociete = rs.getString("CODEPOSTAL_SOCIETE");
            String telephoneSociete = rs.getString("TELEPHONE_SOCIETE");
            String adressemailSociete = rs.getString("ADRESSEMAIL_SOCIETE");
            String commentaireSociete = rs.getString("COMMENTAIRE_SOCIETE");
            String interet = rs.getString("INTERET_PROSPECT");

            LocalDate date = dateProspect.toLocalDate();
            return new Prospect(id,raisonsocialSociete,numerorueSociete,nomrueSociete,codepostalSociete,
                    villeSociete,telephoneSociete,adressemailSociete,commentaireSociete,date,interet);
        } else {
            throw new daoException("find by name error ");
        }
    }

    public static void create(Prospect prospect) throws SQLException, IOException, daoException {
        Connection connection = Connexion.getInstance();
        String query = "INSERT INTO PROSPECT" +
                "(DATE_PROSPECT" +
                ",RAISONSOCIAL_SOCIETE" +
                ",NUMERORUE_SOCIETE" +
                ",NOMRUE_SOCIETE" +
                ",VILLE_SOCIETE" +
                ",CODEPOSTAL_SOCIETE" +
                ",TELEPHONE_SOCIETE" +
                ",ADRESSEMAIL_SOCIETE" +
                ",COMMENTAIRE_SOCIETE" +
                ",INTERET_PROSPECT)" +
                "VALUES" +
                "(?" +
                ",?" +
                ",?" +
                ",?" +
                ",?" +
                ",?" +
                ",?" +
                ",?" +
                ",?" +
                ",?)" ;
        if (connection == null) {
            MyLogg.LOGGER.log(Level.SEVERE, "Connexion échoué DaoProspect -> create");
            throw new daoException("La connexion à la base de données a échoué");
        }
        PreparedStatement statement = connection.prepareStatement(query);
        if (statement == null) {
            throw new daoException("create : Impossible de créer le statement pour exécuter la requête");
        }
        Date date = Date.valueOf(prospect.getDateProspection());
        statement.setDate(1,date);
        statement.setString(2,prospect.getRaisonSociale());
        statement.setString(3,prospect.getNumeroRue());
        statement.setString(4,prospect.getNomRue());
        statement.setString(5,prospect.getVille());
        statement.setString(6,prospect.getCodePostal());
        statement.setString(7,prospect.getTelephone());
        statement.setString(8,prospect.getAdresseMail());
        statement.setString(9,prospect.getCommentaire());
        statement.setString(10,prospect.getInteret());
        int lignesModifiees = statement.executeUpdate();
        if (lignesModifiees <= 0){
            throw new daoException("erreur d'insert into");
        }
        statement.close();
    }

    public static void update(Prospect prospect) throws SQLException, IOException, daoException {
        Connection connection = Connexion.getInstance();
        String query = "UPDATE PROSPECT " +
                "   SET DATE_PROSPECT = ?" +
                ",RAISONSOCIAL_SOCIETE = ?" +
                ",NUMERORUE_SOCIETE = ?" +
                ",NOMRUE_SOCIETE = ?" +
                ",VILLE_SOCIETE = ?" +
                ",CODEPOSTAL_SOCIETE = ?" +
                ",TELEPHONE_SOCIETE = ?" +
                ",ADRESSEMAIL_SOCIETE = ?" +
                ",COMMENTAIRE_SOCIETE = ?" +
                ",INTERET_PROSPECT = ?" +
                " WHERE ID_PROSPECT =  ?";

        if (connection == null) {
            MyLogg.LOGGER.log(Level.SEVERE, "Connexion échoué DaoProspect -> Update");
            throw new daoException("La connexion à la base de données a échoué");
        }
        PreparedStatement statement = connection.prepareStatement(query);
        if (statement == null) {
            throw new daoException("create : Impossible de préparer la requête, statement est null");
        }
        Date date = Date.valueOf(prospect.getDateProspection());
        statement.setDate(1,date);
        statement.setString(2,prospect.getRaisonSociale());
        statement.setString(3,prospect.getNumeroRue());
        statement.setString(4,prospect.getNomRue());
        statement.setString(5,prospect.getVille());
        statement.setString(6,prospect.getCodePostal());
        statement.setString(7,prospect.getTelephone());
        statement.setString(8,prospect.getAdresseMail());
        statement.setString(9,prospect.getCommentaire());
        statement.setString(10,prospect.getInteret());
        statement.setInt(11,prospect.getIdentifiant());
        int lignesModifiees = statement.executeUpdate();
        if (lignesModifiees <= 0){
            throw new daoException("erreur d'update Prospect");
        }
        statement.close();

    }

    public static void delete(int id) throws SQLException, IOException, daoException {
        Connection connection = Connexion.getInstance();
        String query = "DELETE FROM PROSPECT WHERE ID_PROSPECT = ?";
        if (connection == null) {
            MyLogg.LOGGER.log(Level.SEVERE, "Connexion échoué DaoProspect -> delete");
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
