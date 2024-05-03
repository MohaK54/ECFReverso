package controleur;

import dao.DaoClient;
import dao.DaoProspect;
import dao.daoException;
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
    public static ArrayList<String> disp(String entity) throws Exception {
        if (entity.equals("Client")) {
            return DaoClient.findAllRS();
        } else {
            return DaoProspect.findAllRS();
        }
    }

    /**
     * Lance le formulaire correspondant à l'option spécifiée.
     *
     * @param option L'option sélectionnée.
     */
    public static void launchFormulaire(String option) {
        ControleurFormulaire.init(option);
    }

    /**
     * Lance l'affichage correspondant à l'option spécifiée.
     *
     * @param option L'option sélectionnée.
     */
    public static void launchAffichage(String option) {
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
    public static void choiceClient(String raisonSocial) throws Exception {
        ControleurFormulaire.selecClient(raisonSocial);
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
    public static void choiceProspect(String raisonSocial) throws Exception {
        ControleurFormulaire.selectProspect(raisonSocial);
    }
}
