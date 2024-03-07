package controleur;

import dao.DaoClient;
import dao.DaoProspect;
import dao.daoException;
import model.Client;
import model.Prospect;
import model.modelException;
import vue.Affichage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Le contrôleur pour la gestion de l'affichage de la liste de l'application.
 */
public class ControleurAffichage {

    /**
     * Initialise l'affichage pour une entité spécifique.
     *
     * @param entity Le nom de l'entité pour laquelle l'affichage est initialisé.
     */
    public static void init(String entity) {
        Affichage affichage = new Affichage(entity);
        affichage.setVisible(true);
    }

    /**
     * Récupère tous les clients depuis la couche DAO.
     *
     * @return Une liste contenant tous les clients.
     * @throws SQLException   Si une exception SQL survient.
     * @throws IOException    Si une exception d'entrée/sortie survient.
     * @throws daoException   Si une exception DAO survient.
     * @throws modelException Si une exception liée au modèle survient.
     */
    public static ArrayList<Client> findAllClient() throws SQLException, IOException, daoException, modelException {
        return DaoClient.findAll();
    }

    /**
     * Récupère tous les prospects depuis la couche DAO.
     *
     * @return Une liste contenant tous les prospects.
     * @throws SQLException   Si une exception SQL survient.
     * @throws IOException    Si une exception d'entrée/sortie survient.
     * @throws daoException   Si une exception DAO survient.
     * @throws modelException Si une exception liée au modèle survient.
     */
    public static ArrayList<Prospect> findAllProspect() throws SQLException, IOException, daoException, modelException {
        return DaoProspect.findAll();
    }

    /**
     * Lance l'écran d'accueil.
     */
    public static void launchAccueil() {
        ControleurAccueil.init();
    }
}
