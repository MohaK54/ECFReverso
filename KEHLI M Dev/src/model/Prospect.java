package model;

import utilities.DateFormat;

import java.time.LocalDate;

/**
 * Cette classe représente un prospect dans le système.
 */
public class Prospect extends Societe {

    private LocalDate dateProspection;
    private String interet;

    /**
     * Constructeur par défaut.
     */
    public Prospect() {
    }

    /**
     * Constructeur avec tous les paramètres.
     *
     * @param identifiant     L'identifiant du prospect.
     * @param raisonSociale   La raison sociale du prospect.
     * @param numeroRue       Le numéro de rue du prospect.
     * @param nomRue          Le nom de rue du prospect.
     * @param codePostal      Le code postal du prospect.
     * @param ville           La ville du prospect.
     * @param telephone       Le numéro de téléphone du prospect.
     * @param adresseMail     L'adresse email du prospect.
     * @param commentaire     Un commentaire sur le prospect.
     * @param dateProspection La date de prospection du prospect.
     * @param interet         L'intérêt du prospect (oui/non).
     * @throws modelException Si une exception survient lors de l'instanciation.
     */
    public Prospect(int identifiant, String raisonSociale, String numeroRue, String nomRue, String codePostal,
                    String ville, String telephone, String adresseMail, String commentaire,
                    LocalDate dateProspection, String interet) throws modelException {
        super(identifiant, raisonSociale, numeroRue, nomRue, codePostal, ville, telephone, adresseMail, commentaire);
        setDateProspection(dateProspection);
        setInteret(interet);
    }

    /**
     * Constructeur sans le paramètre commentaire.
     *
     * @param identifiant     L'identifiant du prospect.
     * @param raisonSociale   La raison sociale du prospect.
     * @param numeroRue       Le numéro de rue du prospect.
     * @param nomRue          Le nom de rue du prospect.
     * @param codePostal      Le code postal du prospect.
     * @param ville           La ville du prospect.
     * @param telephone       Le numéro de téléphone du prospect.
     * @param adresseMail     L'adresse email du prospect.
     * @param dateProspection La date de prospection du prospect.
     * @param interet         L'intérêt du prospect (oui/non).
     * @throws modelException Si une exception survient dans la couche modèle.
     */
    public Prospect(int identifiant, String raisonSociale, String numeroRue, String nomRue, String codePostal,
                    String ville, String telephone, String adresseMail,
                    LocalDate dateProspection, String interet) throws modelException {
        super(identifiant, raisonSociale, numeroRue, nomRue, codePostal, ville, telephone, adresseMail);
        setDateProspection(dateProspection);
        setInteret(interet);
    }

    /**
     * Récupère la date de prospection du prospect.
     *
     * @return La date de prospection du prospect.
     */
    public LocalDate getDateProspection() {
        return this.dateProspection;
    }

    /**
     * Définit la date de prospection du prospect.
     *
     * @param dateProspection La date de prospection saisi.
     * @throws modelException Si la date de prospection est nulle.
     */
    public void setDateProspection(LocalDate dateProspection) throws modelException {
        if (dateProspection == null) {
            throw new modelException("La date doit-être remplis");
        }
        this.dateProspection = dateProspection;
    }

    /**
     * Récupère l'intérêt du prospect.
     *
     * @return L'intérêt du prospect (oui/non).
     */
    public String getInteret() {
        return interet;
    }

    /**
     * Définit l'intérêt du prospect.
     *
     * @param interet L'intérêt du prospect saisi.
     * @throws modelException Si l'intérêt n'est pas clair (différent de "oui" ou "non").
     */
    public void setInteret(String interet) throws modelException {
        if (interet == null || !interet.equals("oui") && !interet.equals("non")) {
            throw new modelException("l'interet n'est pas claire");
        }
        this.interet = interet;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de l'objet Prospect.
     *
     * @return Une chaîne de caractères représentant l'objet Prospect.
     */
    @Override
    public String toString() {
        return super.toString() +
                " date de Prospection : " + DateFormat.formatDate(getDateProspection()) +
                ", interet : " + interet + '\'';
    }
}
