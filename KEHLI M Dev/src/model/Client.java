package model;

/**
 * Cette classe représente un client dans le système.
 */
public class Client extends Societe {
    private double chiffreAffaire;
    private int nbrEmploye;

    /**
     * Constructeur par défaut.
     */
    public Client() {
    }

    /**
     * Constructeur avec tous les paramètres.
     *
     * @param id            L'identifiant du client.
     * @param raisonSociale La raison sociale du client.
     * @param numeroRue     Le numéro de rue du client.
     * @param nomRue        Le nom de rue du client.
     * @param codePostal    Le code postal du client.
     * @param ville         La ville du client.
     * @param telephone     Le numéro de téléphone du client.
     * @param adresseMail   L'adresse email du client.
     * @param commentaire   Un commentaire sur le client.
     * @param chiffreAffaire Le chiffre d'affaires du client.
     * @param nbrEmploye     Le nombre d'employés du client.
     * @throws modelException Si une exception survient dans la couche modèle.
     */
    public Client(int id, String raisonSociale, String numeroRue, String nomRue, String codePostal, String ville,
                  String telephone, String adresseMail, String commentaire, double chiffreAffaire, int nbrEmploye) throws modelException {
        super(id, raisonSociale, numeroRue, nomRue, codePostal, ville, telephone, adresseMail, commentaire);
        this.setChiffreDaffaire(chiffreAffaire);
        this.setNombreEmployer(nbrEmploye);
    }

    /**
     * Constructeur sans le paramètre commentaire.
     *
     * @param id            L'identifiant du client.
     * @param raisonSociale La raison sociale du client.
     * @param numeroRue     Le numéro de rue du client.
     * @param nomRue        Le nom de rue du client.
     * @param codePostal    Le code postal du client.
     * @param ville         La ville du client.
     * @param telephone     Le numéro de téléphone du client.
     * @param adresseMail   L'adresse email du client.
     * @param chiffreAffaire Le chiffre d'affaires du client.
     * @param nbrEmploye     Le nombre d'employés du client.
     * @throws modelException Si une exception survient lors de l'instanciation du client.
     */
    public Client(int id, String raisonSociale, String numeroRue, String nomRue, String codePostal, String ville,
                  String telephone, String adresseMail, double chiffreAffaire, int nbrEmploye) throws modelException {
        super(id, raisonSociale, numeroRue, nomRue, codePostal, ville, telephone, adresseMail);
        this.setChiffreDaffaire(chiffreAffaire);
        this.setNombreEmployer(nbrEmploye);
    }

    /**
     * Récupère le chiffre d'affaires du client.
     *
     * @return Le chiffre d'affaires du client.
     */
    public double getChiffreAffaire() {
        return this.chiffreAffaire;
    }

    /**
     * Définit le chiffre d'affaires du client.
     *
     * @param chiffreAffaire Le chiffre d'affaires saisi .
     * @throws modelException Si le chiffre d'affaires est inférieur ou égal à 200.
     */
    public void setChiffreDaffaire(double chiffreAffaire) throws modelException {
        if (chiffreAffaire <= 200) {
            throw new modelException("Le chiffre d’affaires doit être supérieur à 200");
        }
        this.chiffreAffaire = chiffreAffaire;
    }

    /**
     * Récupère le nombre d'employés du client.
     *
     * @return Le nombre d'employés du client.
     */
    public int getNbrEmploye() {
        return this.nbrEmploye;
    }

    /**
     * Définit le nombre d'employés du client.
     *
     * @param nbrEmploye Le nombre d'employés saisi .
     * @throws modelException Si le nombre d'employés est inférieur à 1.
     */
    public void setNombreEmployer(int nbrEmploye) throws modelException {
        if (nbrEmploye < 1) {
            throw new modelException("Le nombre d’employés doit être strictement supérieur à 0");
        }
        this.nbrEmploye = nbrEmploye;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de l'objet Client.
     *
     * @return Une chaîne de caractères représentant l'objet Client.
     */
    @Override
    public String toString() {
        return super.toString() + "Client{" +
                "chiffreDaffaire=" + chiffreAffaire +
                ", nombreEmployer=" + nbrEmploye +
                '}';
    }
}
