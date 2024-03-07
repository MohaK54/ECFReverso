package controleur;

import dao.DaoClient;
import dao.DaoProspect;
import dao.daoException;
import model.Client;
import model.Prospect;
import model.modelException;
import vue.Accueil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Le contrôleur pour la gestion de l'accueil de l'application.
 */
public class ControleurAccueil {
    private static final Accueil accueil = new Accueil();

    /**
     * Initialise l'interface utilisateur de l'accueil.
     */
    public static void init() {
        accueil.setVisible(true);
    }

    /**
     * Récupère et affiche les noms des entités spécifiées.
     *
     * @param entity Le type d'entité à récupérer ("Client" ou "Prospect").
     * @return Une liste contenant les noms des entités récupérées.
     * @throws SQLException    Si une exception SQL survient.
     * @throws IOException     Si une exception d'entrée/sortie survient.
     * @throws daoException    Si une exception DAO survient.
     * @throws modelException Si une exception liée au modèle survient.
     */
    public static ArrayList<String> disp(String entity) throws SQLException, IOException, daoException, modelException {
        if (entity.equals("Client")) {
            return DaoClient.findAllRS();
        } else {
            return DaoProspect.findAllRS();
        }
    }

    /**
     * Recherche un client par son nom.
     *
     * @param nom Le nom du client à rechercher.
     * @return Le client trouvé, s'il existe, sinon null.
     * @throws SQLException    Si une exception SQL survient.
     * @throws IOException     Si une exception d'entrée/sortie survient.
     * @throws daoException    Si une exception DAO survient.
     * @throws modelException Si une exception liée au modèle survient.
     */
    public static Client findClient(String nom) throws SQLException, IOException, daoException, modelException {
        return DaoClient.findByName(nom);
    }

    /**
     * Recherche un prospect par son nom.
     *
     * @param nom Le nom du prospect à rechercher.
     * @return Le prospect trouvé, s'il existe, sinon null.
     * @throws SQLException    Si une exception SQL survient.
     * @throws IOException     Si une exception d'entrée/sortie survient.
     * @throws daoException    Si une exception DAO survient.
     * @throws modelException Si une exception liée au modèle survient.
     */
    public static Prospect findProspect(String nom) throws SQLException, IOException, daoException, modelException {
        return DaoProspect.findByName(nom);
    }

    /**
     * Lance le formulaire correspondant à l'option spécifiée.
     *
     * @param option L'option sélectionnée.
     * @throws SQLException    Si une exception SQL survient.
     * @throws IOException     Si une exception d'entrée/sortie survient.
     * @throws daoException    Si une exception DAO survient.
     * @throws modelException Si une exception liée au modèle survient.
     */
    public static void launchFormulaire(String option) throws SQLException, IOException, daoException, modelException {
        ControleurFormulaire.init(option);
    }

    /**
     * Lance l'affichage correspondant à l'option spécifiée.
     *
     * @param option L'option sélectionnée.
     * @throws SQLException    Si une exception SQL survient.
     * @throws IOException     Si une exception d'entrée/sortie survient.
     * @throws daoException    Si une exception DAO survient.
     * @throws modelException Si une exception liée au modèle survient.
     */
    public static void launchAffichage(String option) throws SQLException, IOException, daoException, modelException {
        ControleurAffichage.init(option);
    }

    /**
     * Sélectionne un client pour le formulaire.
     *
     * @param raisonSocial La raison sociale du client à sélectionner.
     * @throws SQLException    Si une exception SQL survient.
     * @throws IOException     Si une exception d'entrée/sortie survient.
     * @throws daoException    Si une exception DAO survient.
     * @throws modelException Si une exception liée au modèle survient.
     */
    public static void choiceClient(String raisonSocial) throws SQLException, IOException, daoException, modelException {
        ControleurFormulaire.selecClient(findClient(raisonSocial));
    }

    /**
     * Sélectionne un prospect pour le formulaire.
     *
     * @param raisonSocial La raison sociale du prospect à sélectionner.
     * @throws SQLException    Si une exception SQL survient.
     * @throws IOException     Si une exception d'entrée/sortie survient.
     * @throws daoException    Si une exception DAO survient.
     * @throws modelException Si une exception liée au modèle survient.
     */
    public static void choiceProspect(String raisonSocial) throws SQLException, IOException, daoException, modelException {
        ControleurFormulaire.selectProspect(findProspect(raisonSocial));
    }
}
