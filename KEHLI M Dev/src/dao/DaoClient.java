package dao;

import model.Client;
import model.modelException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;

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
    public static ArrayList<Client> findAll() throws Exception {

        try (Connection connection = Connexion.getInstance();
             Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT ID_CLIENT, CHIFFREAFFAIRE_CLIENT, RAISONSOCIAL_SOCIETE,NUMERORUE_SOCIETE,NOMRUE_SOCIETE," +
                    "VILLE_SOCIETE,CODEPOSTAL_SOCIETE, TELEPHONE_SOCIETE, ADRESSEMAIL_SOCIETE, COMMENTAIRE_SOCIETE,"
                    + "NBREMPLOYE_CLIENT FROM CLIENT "))
        {
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
                Client client = new Client(
                        id,
                        raisonsocialSociete.substring(0, 1).toUpperCase()+raisonsocialSociete.substring(1),
                        numerorueSociete,
                        nomrueSociete,
                        codepostalSociete,
                        villeSociete,
                        telephoneSociete,
                        adressemailSociete,
                        commentaireSociete,
                        chiffreAffaire,
                        nbremployeClient);
                clients.add(client);
            }

            statement.close();

            return clients;
        }catch(IOException | SQLException e){
            throw new daoException(Level.SEVERE,"find All impossible, vérifiez votre base de données "+e.getMessage());
        }catch (modelException me) {
            throw new daoException(Level.SEVERE,"find All impossible, données table incompatible avec l'objet " + me.getMessage());
        }
    }

    /**
     * Récupère la Raison Social de tous les clients de la base de données.
     *
     * @return Une liste de noms sociaux de tous les clients.
     * @throws SQLException    Si une erreur SQL survient.
     * @throws IOException     Si une erreur d'entrée/sortie survient.
     * @throws daoException   Si une exception DAO survient.
     */
    public static ArrayList<String> findAllRS() throws Exception {

        try(Connection connection = Connexion.getInstance();
        Statement statement = connection.createStatement()){

            ResultSet rs = statement.executeQuery("SELECT RAISONSOCIAL_SOCIETE FROM CLIENT");
            ArrayList<String> raisonSocials = new ArrayList<>();
            while (rs.next()) {
                String raisonsocialSociete = rs.getString("RAISONSOCIAL_SOCIETE");
                raisonSocials.add(raisonsocialSociete);
            }

            statement.close();

            return raisonSocials;
        }catch(IOException | SQLException e){
            throw new daoException(Level.SEVERE, "find All RS impossible, vérifiez votre base de données "+e.getMessage());
        }
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
    public static Client findByName(String name) throws Exception {
        try(Connection connection = Connexion.getInstance();
        PreparedStatement statement = connection.prepareStatement("SELECT ID_CLIENT, CHIFFREAFFAIRE_CLIENT, RAISONSOCIAL_SOCIETE,NUMERORUE_SOCIETE,NOMRUE_SOCIETE," +
                "VILLE_SOCIETE,CODEPOSTAL_SOCIETE, TELEPHONE_SOCIETE, ADRESSEMAIL_SOCIETE, COMMENTAIRE_SOCIETE,"
                + "NBREMPLOYE_CLIENT FROM CLIENT WHERE RAISONSOCIAL_SOCIETE = ?")) {
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
            } else{
                throw new daoException(Level.INFO, "Aucun Client n'a été trouvé");
            }
        }catch(IOException | SQLException e){
            throw new daoException(Level.SEVERE,"find By name impossible, vérifiez votre base de données "+e.getMessage());
        }
        catch (modelException me) {
            throw new daoException(Level.SEVERE,"find By name impossible, données table incompatible avec l'objet "+me.getMessage());
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
    public static void create(Client client) throws Exception {
        try(
        PreparedStatement statement = getStatement("INSERT INTO CLIENT (CHIFFREAFFAIRE_CLIENT, RAISONSOCIAL_SOCIETE, NUMERORUE_SOCIETE, " +
                "NOMRUE_SOCIETE, VILLE_SOCIETE, CODEPOSTAL_SOCIETE, TELEPHONE_SOCIETE, ADRESSEMAIL_SOCIETE, " +
                "COMMENTAIRE_SOCIETE, NBREMPLOYE_CLIENT) VALUES (?,?,?,?,?,?,?,?,?,?) ",client)) {
            statement.executeUpdate();
        }catch(SQLException e){
            if (e.getErrorCode()==2627)
            {
                throw new daoException(Level.INFO,"La raison social existe déja");
            } else{
                throw new daoException(Level.SEVERE,"erreur Create Client " +e.getMessage()+ " error : "+e.getErrorCode());
            }
        }catch (IOException ie){
            throw new daoException(Level.SEVERE,"erreur Create Prospect " +ie.getMessage() );
        }

    }

    /**
     * Met à jour les informations d'un client dans la base de données.
     *
     * @param client Les nouvelles informations du client.
     * @throws SQLException    Si une erreur SQL survient.
     * @throws IOException     Si une erreur d'entrée/sortie survient.
     * @throws daoException   Si une exception DAO survient.
     */
    public static void update(Client client) throws Exception {
        try(
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
                " WHERE ID_CLIENT =  ?",client);){

        statement.setInt(11, client.getIdentifiant());
        statement.executeUpdate();
        }catch(SQLException e){
            if (e.getErrorCode()==2627)
            {
                throw new daoException(Level.INFO,"La raison social existe déja");
            } else{
                throw new daoException(Level.SEVERE,"erreur Update Client " +e.getMessage()+ " error : "+e.getErrorCode());
            }
        }catch (IOException ie){
            throw new daoException(Level.SEVERE,"erreur Update Client " +ie.getMessage() );
        }


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
    private static PreparedStatement getStatement(String query, Client client) throws Exception {
        Connection connection = Connexion.getInstance();


        PreparedStatement statement = connection.prepareStatement(query);

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
    public static void delete(int id) throws Exception {
        try(
        Connection connection = Connexion.getInstance();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM CLIENT WHERE ID_CLIENT = ?")) {

            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(IOException | SQLException e){
            throw new daoException(Level.SEVERE, "Delete impossible, vérifiez votre base de données "+e.getMessage());
        }
    }
}
