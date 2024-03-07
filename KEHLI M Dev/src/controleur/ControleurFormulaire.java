package controleur;

import dao.DaoClient;
import dao.DaoProspect;
import model.Client;
import model.Prospect;
import vue.Formulaire;
import java.time.LocalDate;

/**
 * Le contrôleur pour la gestion du formulaire de l'application.
 */
public class ControleurFormulaire {
    public static Client clientSelect;
    public static Prospect prospectSelect;

    /**
     * Initialise le formulaire pour une entité spécifique.
     *
     * @param entity Le nom de l'entité pour laquelle le formulaire est initialisé.
     */
    public static void init(String entity) {
        Formulaire formulaire = new Formulaire(entity);
        formulaire.setVisible(true);
    }

    /**
     * Crée un nouveau client dans la base de données.
     *
     * @param id         L'identifiant du client.
     * @param rs         La raison sociale du client.
     * @param numRue     Le numéro de rue du client.
     * @param nomRue     Le nom de la rue du client.
     * @param ville      La ville du client.
     * @param cp         Le code postal du client.
     * @param tel        Le numéro de téléphone du client.
     * @param mail       L'adresse e-mail du client.
     * @param comm       Les commentaires sur le client.
     * @param ca         Le chiffre d'affaires du client.
     * @param nbrEmploye Le nombre d'employés du client.
     * @throws Exception Si une exception survient lors de la création du client.
     */
    public static void creerClient(
            int id,
            String rs,
            String numRue,
            String nomRue,
            String ville,
            String cp,
            String tel,
            String mail,
            String comm,
            double ca,
            int nbrEmploye) throws Exception {
        Client client = new Client(id, rs, numRue, nomRue, cp, ville, tel, mail, comm, ca, nbrEmploye);
        DaoClient.create(client);
    }

    /**
     * Crée un nouveau prospect dans la base de données.
     *
     * @param id        L'identifiant du prospect.
     * @param rs        La raison sociale du prospect.
     * @param numRue    Le numéro de rue du prospect.
     * @param nomRue    Le nom de la rue du prospect.
     * @param ville     La ville du prospect.
     * @param cp        Le code postal du prospect.
     * @param tel       Le numéro de téléphone du prospect.
     * @param mail      L'adresse e-mail du prospect.
     * @param comm      Les commentaires sur le prospect.
     * @param interet   L'intérêt du prospect.
     * @param date      La date du prospect.
     * @throws Exception Si une exception survient lors de la création du prospect.
     */
    public static void creerProspect(
            int id,
            String rs,
            String numRue,
            String nomRue,
            String ville,
            String cp,
            String tel,
            String mail,
            String comm,
            String interet,
            LocalDate date) throws Exception {
        Prospect prospect = new Prospect(id, rs, numRue, nomRue, cp, ville, tel, mail, comm, date, interet);
        DaoProspect.create(prospect);
    }

    /**
     * Sélectionne un client.
     *
     * @param client Le client à sélectionner.
     */
    public static void selecClient(Client client) {
        clientSelect = client;
    }

    /**
     * Sélectionne un prospect.
     *
     * @param prospect Le prospect à sélectionner.
     */
    public static void selectProspect(Prospect prospect) {
        prospectSelect = prospect;
    }

    /**
     * Met à jour les informations d'un client dans la base de données.
     *
     * @param id         L'identifiant du client.
     * @param rs         La raison sociale du client.
     * @param numRue     Le numéro de rue du client.
     * @param nomRue     Le nom de la rue du client.
     * @param ville      La ville du client.
     * @param cp         Le code postal du client.
     * @param tel        Le numéro de téléphone du client.
     * @param mail       L'adresse e-mail du client.
     * @param comm       Les commentaires sur le client.
     * @param ca         Le chiffre d'affaires du client.
     * @param nbrEmploye Le nombre d'employés du client.
     * @throws Exception Si une exception survient lors de la mise à jour du client.
     */
    public static void updateClient(int id,
                                    String rs,
                                    String numRue,
                                    String nomRue,
                                    String ville,
                                    String cp,
                                    String tel,
                                    String mail,
                                    String comm,
                                    double ca,
                                    int nbrEmploye) throws Exception {
        Client client = new Client(id, rs, numRue, nomRue, cp, ville, tel, mail, comm, ca, nbrEmploye);
        DaoClient.update(client);
    }

    /**
     * Met à jour les informations d'un prospect dans la base de données.
     *
     * @param id        L'identifiant du prospect.
     * @param rs        La raison sociale du prospect.
     * @param numRue    Le numéro de rue du prospect.
     * @param nomRue    Le nom de la rue du prospect.
     * @param ville     La ville du prospect.
     * @param cp        Le code postal du prospect.
     * @param tel       Le numéro de téléphone du prospect.
     * @param mail      L'adresse e-mail du prospect.
     * @param comm      Les commentaires sur le prospect.
     * @param interet   L'intérêt du prospect.
     * @param date      La date du prospect.
     * @throws Exception Si une exception survient lors de la mise à jour du prospect.
     */
    public static void updateProspect(
            int id,
            String rs,
            String numRue,
            String nomRue,
            String ville,
            String cp,
            String tel,
            String mail,
            String comm,
            String interet,
            LocalDate date) throws Exception {
        Prospect prospect = new Prospect(id, rs, numRue, nomRue, cp, ville, tel, mail, comm, date, interet);
        DaoProspect.update(prospect);
    }

    /**
     * Supprime un client de la base de données.
     *
     * @param id L'identifiant du client à supprimer.
     * @throws Exception Si une exception survient lors de la suppression du client.
     */
    public static void deleteClient(int id) throws Exception {
        DaoClient.delete(id);
    }

    /**
     * Supprime un prospect de la base de données.
     *
     * @param id L'identifiant du prospect à supprimer.
     * @throws Exception Si une exception survient lors de la suppression du prospect.
     */
    public static void deleteProspect(int id) throws Exception {
        DaoProspect.delete(id);
    }

    /**
     * Lance l'écran d'accueil.
     */
    public static void launchAccueil() {
        ControleurAccueil.init();
    }
}
