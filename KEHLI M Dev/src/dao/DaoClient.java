package dao;

import model.Client;
import model.modelException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 * Le lien entre le Client et la base de données
 */
public class DaoClient {
    /**
     * Récupère tous les clients de la base de données.
     *
     * @return Une liste de tous les clients.
     * @throws SQLException    Si une erreur SQL survient.
     * @throws IOException     Si une erreur d'entrée/sortie survient.
     * @throws modelException Si une exception liée au modèle survient.
     * @throws daoException   Si une exception DAO survient.
     */
    public static ArrayList<Client> findAll() throws SQLException, IOException, modelException, daoException {
        Connection connection = Connexion.getInstance();
        Statement statement;
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

        statement.close();

        return clients;
    }

    /**
     * Récupère la Raison Social de tous les clients de la base de données.
     *
     * @return Une liste de noms sociaux de tous les clients.
     * @throws SQLException    Si une erreur SQL survient.
     * @throws IOException     Si une erreur d'entrée/sortie survient.
     * @throws daoException   Si une exception DAO survient.
     */
    public static ArrayList<String> findAllRS() throws SQLException, IOException, daoException {
        Connection connection = Connexion.getInstance();
        Statement statement;
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

        statement.close();

        return raisonSocials;
    }

    /**
     * Recherche un client par son nom social.
     *
     * @param name Le nom social du client à rechercher.
     * @return Le client correspondant au nom social donné.
     * @throws SQLException    Si une erreur SQL survient.
     * @throws IOException     Si une erreur d'entrée/sortie survient.
     * @throws modelException Si une exception liée au modèle survient.
     * @throws daoException   Si une exception DAO survient.
     */
    public static Client findByName(String name) throws SQLException, IOException, modelException, daoException {
        Connection connection = Connexion.getInstance();
        PreparedStatement statement;
        String query =
                "SELECT ID_CLIENT, CHIFFREAFFAIRE_CLIENT, RAISONSOCIAL_SOCIETE,NUMERORUE_SOCIETE,NOMRUE_SOCIETE," +
                        "VILLE_SOCIETE,CODEPOSTAL_SOCIETE, TELEPHONE_SOCIETE, ADRESSEMAIL_SOCIETE, COMMENTAIRE_SOCIETE,"
                        + "NBREMPLOYE_CLIENT FROM CLIENT WHERE RAISONSOCIAL_SOCIETE = ?";

        statement = connection.prepareStatement(query);
        statement.setString(1, name);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
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
            return new Client(id, raisonsocialSociete, numerorueSociete,
                    nomrueSociete, codepostalSociete,
                    villeSociete, telephoneSociete, adressemailSociete,
                    commentaireSociete, chiffreAffaire, nbremployeClient);
        } else {
            throw new daoException("find by name error");
        }
    }

    /**
     * Crée un nouveau client dans la base de données.
     *
     * @param client Les informations du client à créer.
     * @throws SQLException    Si une erreur SQL survient.
     * @throws IOException     Si une erreur d'entrée/sortie survient.
     * @throws daoException   Si une exception DAO survient.
     */
    public static void create(Client client) throws SQLException, IOException, daoException {
        PreparedStatement statement = getStatement("INSERT INTO CLIENT (CHIFFREAFFAIRE_CLIENT, RAISONSOCIAL_SOCIETE, NUMERORUE_SOCIETE, " +
                "NOMRUE_SOCIETE, VILLE_SOCIETE, CODEPOSTAL_SOCIETE, TELEPHONE_SOCIETE, ADRESSEMAIL_SOCIETE, " +
                "COMMENTAIRE_SOCIETE, NBREMPLOYE_CLIENT) VALUES (?,?,?,?,?,?,?,?,?,?) ",client);
        int lignesModifiees = statement.executeUpdate();
        if (lignesModifiees <= 0) {
            throw new daoException("erreur d'insert into");
        }
        statement.close();
    }

    /**
     * Met à jour les informations d'un client dans la base de données.
     *
     * @param client Les nouvelles informations du client.
     * @throws SQLException    Si une erreur SQL survient.
     * @throws IOException     Si une erreur d'entrée/sortie survient.
     * @throws daoException   Si une exception DAO survient.
     */
    public static void update(Client client) throws SQLException, IOException, daoException {
        PreparedStatement statement = getStatement("UPDATE CLIENT " +
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
                " WHERE ID_CLIENT =  ?",client);

        statement.setInt(11, client.getIdentifiant());
        int lignesModifiees = statement.executeUpdate();
        if (lignesModifiees <= 0) {
            throw new daoException("erreur d'update Client");
        }
        statement.close();

    }

    /**
     * Prépare et retourne un objet PreparedStatement pour éviter de répeter mon code.
     *
     * @param query  La requête SQL à préparer.
     * @param client Les informations du client à utiliser dans la requête.
     * @return Un objet PreparedStatement prêt à être exécuté.
     * @throws SQLException    Si une erreur SQL survient.
     * @throws IOException     Si une erreur d'entrée/sortie survient.
     * @throws daoException   Si une exception DAO survient.
     */
    private static PreparedStatement getStatement(String query, Client client) throws SQLException, IOException, daoException {
        Connection connection = Connexion.getInstance();

        if (connection == null) {
            throw new daoException("La connexion à la base de données a échoué");
        }
        PreparedStatement statement = connection.prepareStatement(query);
        if (statement == null) {
            throw new daoException("Impossible de créer le statement pour exécuter la requête");
        }
        statement.setDouble(1, client.getChiffreAffaire());
        statement.setString(2, client.getRaisonSociale());
        statement.setString(3, client.getNumeroRue());
        statement.setString(4, client.getNomRue());
        statement.setString(5, client.getVille());
        statement.setString(6, client.getCodePostal());
        statement.setString(7, client.getTelephone());
        statement.setString(8, client.getAdresseMail());
        statement.setString(9, client.getCommentaire());
        statement.setInt(10, client.getNbrEmploye());
        return statement;
    }


    /**
     * Supprime un client de la base de données.
     *
     * @param id L'identifiant du client à supprimer.
     * @throws SQLException    Si une erreur SQL survient.
     * @throws IOException     Si une erreur d'entrée/sortie survient.
     * @throws daoException   Si une exception DAO survient.
     */
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
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
    }
}
