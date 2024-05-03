package dao;

import model.Prospect;
import model.modelException;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 * Le lien entre le Prospect et la base de données
 */
public class DaoProspect {

    /**
     * Récupère tous les prospects de la base de données.
     *
     * @return Une liste de tous les prospects présents dans la base de données.
     * @throws SQLException     Si une erreur SQL survient.
     * @throws IOException      Si une erreur d'entrée/sortie survient.
     * @throws modelException  Si une exception survient dans la couche modèle.
     * @throws daoException    Si une exception survient lors de la connexion à ma bdd.
     */
    public static ArrayList<Prospect> findAll() throws Exception {

        try (Connection connection = Connexion.getInstance();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT ID_PROSPECT" +
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
                " FROM PROSPECT")) {


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
                Prospect prospect = new Prospect(id,
                        raisonsocialSociete.substring(0, 1).toUpperCase()+raisonsocialSociete.substring(1),
                        numerorueSociete, nomrueSociete, codepostalSociete,
                        villeSociete, telephoneSociete, adressemailSociete, commentaireSociete, date, interet);
                prospects.add(prospect);
            }
            statement.close();
            return prospects;
        }catch(IOException | SQLException e){
            throw new daoException(Level.SEVERE,"find All impossible, vérifiez votre base de données "+e.getMessage());
        }catch (modelException me) {
            throw new daoException(Level.SEVERE,"find All impossible, données table incompatible avec l'objet " + me.getMessage());
        }


    }

    /**
     * Récupère la raisons sociales de tous les prospects de la base de données.
     *
     * @return Une liste des raisons sociales de tous les prospects.
     * @throws SQLException     Si une erreur SQL survient.
     * @throws IOException      Si une erreur d'entrée/sortie survient.
     * @throws daoException    Si une exception survient lors de la connexion à ma bdd.
     */
    public static ArrayList<String> findAllRS() throws Exception {
        try (Connection connection = Connexion.getInstance();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT RAISONSOCIAL_SOCIETE FROM PROSPECT");
            ArrayList<String> prospects = new ArrayList<>();
            while (rs.next()) {
                String raisonsocialSociete = rs.getString("RAISONSOCIAL_SOCIETE");
                prospects.add(raisonsocialSociete);
            }

            statement.close();

            return prospects;
        } catch (IOException | SQLException e) {
            throw new daoException(Level.SEVERE, "find All RS impossible, vérifiez votre base de données "+e.getMessage());
        }
    }


    /**
     * Recherche un prospect par son nom.
     *
     * @param name Le nom du prospect à rechercher.
     * @return Le prospect correspondant au nom spécifié.
     * @throws SQLException     Si une erreur SQL survient.
     * @throws IOException      Si une erreur d'entrée/sortie survient.
     * @throws modelException  Si une exception survient dans la couche modèle.
     * @throws daoException    Si une exception survient lors de la connexion à ma bdd.
     */
    public static Prospect findByName(String name) throws Exception {
        try(Connection connection = Connexion.getInstance();
        PreparedStatement statement  = connection.prepareStatement("SELECT ID_PROSPECT" +
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
                    " FROM PROSPECT WHERE RAISONSOCIAL_SOCIETE = ?")) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
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
                return new Prospect(id, raisonsocialSociete, numerorueSociete, nomrueSociete, codepostalSociete,
                        villeSociete, telephoneSociete, adressemailSociete, commentaireSociete, date, interet);
            } else {
                throw new daoException(Level.INFO, "Aucun Prospect n'a été trouvé");
            }
        }catch(IOException | SQLException e){
            throw new daoException(Level.SEVERE,"find By name impossible, vérifiez votre base de données " +e.getMessage());
        }
        catch (modelException me) {
            throw new daoException(Level.SEVERE,"find By name impossible, données table incompatible avec l'objet " +me.getMessage());
        }
    }


    /**
     * Crée un nouveau prospect dans la base de données.
     *
     * @param prospect Le prospect à créer.
     * @throws SQLException     Si une erreur SQL survient.
     * @throws IOException      Si une erreur d'entrée/sortie survient.
     * @throws daoException    Si une exception survient lors de la connexion à ma bdd.
     */
    public static void create(Prospect prospect) throws Exception {
        try (Connection connection = Connexion.getInstance();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO PROSPECT" +
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
                ",?)")){

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
            statement.executeUpdate();
        }catch(SQLException e){
            if (e.getErrorCode()==2627)
            {
                throw new daoException(Level.INFO,"La raison social existe déja");
            } else{
                throw new daoException(Level.SEVERE,"erreur Create Prospect " +e.getMessage()+ " error : "+e.getErrorCode());
            }
        } catch (IOException ie){
            throw new daoException(Level.SEVERE,"erreur Create Prospect " +ie.getMessage() );
        }


    }


    /**
     * Met à jour les informations d'un prospect dans la base de données.
     *
     * @param prospect Le prospect avec les nouvelles informations.
     * @throws SQLException     Si une erreur SQL survient.
     * @throws IOException      Si une erreur d'entrée/sortie survient.
     * @throws daoException    Si une exception survient lors de la connexion à ma bdd.
     */
    public static void update(Prospect prospect) throws Exception {
        try (Connection connection = Connexion.getInstance();
        PreparedStatement statement = connection.prepareStatement("UPDATE PROSPECT " +
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
                " WHERE ID_PROSPECT =  ?")) {
            Date date = Date.valueOf(prospect.getDateProspection());
            statement.setDate(1, date);
            statement.setString(2, prospect.getRaisonSociale());
            statement.setString(3, prospect.getNumeroRue());
            statement.setString(4, prospect.getNomRue());
            statement.setString(5, prospect.getVille());
            statement.setString(6, prospect.getCodePostal());
            statement.setString(7, prospect.getTelephone());
            statement.setString(8, prospect.getAdresseMail());
            statement.setString(9, prospect.getCommentaire());
            statement.setString(10, prospect.getInteret());
            statement.setInt(11, prospect.getIdentifiant());
            statement.executeUpdate();
        }catch(SQLException e){
            if (e.getErrorCode()==2627)
            {
                throw new daoException(Level.INFO,"La raison social existe déja");
            } else{
                throw new daoException(Level.SEVERE,"erreur Update Prospect " +e.getMessage()+ " error : "+e.getErrorCode());
            }
        }catch (IOException ie){
            throw new daoException(Level.SEVERE,"erreur Update Prospect " +ie.getMessage() );
        }


    }


    /**
     * Supprime un prospect de la base de données.
     *
     * @param id L'identifiant du prospect à supprimer.
     * @throws SQLException     Si une erreur SQL survient.
     * @throws IOException      Si une erreur d'entrée/sortie survient.
     * @throws daoException    Si une exception survient lors de la connexion à ma bdd.
     */
    public static void delete(int id) throws Exception{
        try(
        Connection connection = Connexion.getInstance();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM PROSPECT WHERE ID_PROSPECT = ?"))
        {
        statement.setInt(1,id);
        statement.executeUpdate();
        }catch(IOException | SQLException e){
            throw new daoException(Level.SEVERE, "Delete impossible, vérifiez votre base de données "+e.getMessage());
        }
    }
}
