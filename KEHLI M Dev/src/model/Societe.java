package model;

import utilities.VerifMail;

/**
 * Cette classe abstraite représente une société dans le système.
 */
public abstract class Societe {

    private int identifiant;
    private String raisonSociale;
    private String numeroRue;
    private String nomRue;
    private String codePostal;
    private String ville;
    private String telephone;
    private String adresseMail;
    private String commentaire;

    /**
     * Constructeur par défaut.
     */
    public Societe() {
    }

    /**
     * Constructeur avec tous les paramètres.
     *
     * @param identifiant    L'identifiant de la société.
     * @param raisonSociale  La raison sociale de la société.
     * @param numeroRue      Le numéro de rue de la société.
     * @param nomRue         Le nom de rue de la société.
     * @param codePostal     Le code postal de la société.
     * @param ville          La ville de la société.
     * @param telephone      Le numéro de téléphone de la société.
     * @param adresseMail    L'adresse email de la société.
     * @param commentaire    Un commentaire sur la société.
     * @throws modelException Si une exception survient dans la couche modèle.
     */
    public Societe(int identifiant, String raisonSociale, String numeroRue, String nomRue,
                   String codePostal, String ville, String telephone, String adresseMail, String commentaire) throws modelException {
        setIdentifiant(identifiant);
        setRaisonSociale(raisonSociale);
        setNumeroRue(numeroRue);
        setNomRue(nomRue);
        setCodePostal(codePostal);
        setVille(ville);
        setTelephone(telephone);
        setAdresseMail(adresseMail);
        setCommentaire(commentaire);
    }

    /**
     * Constructeur sans le paramètre commentaire.
     *
     * @param identifiant   L'identifiant de la société.
     * @param raisonSociale La raison sociale de la société.
     * @param numeroRue     Le numéro de rue de la société.
     * @param nomRue        Le nom de rue de la société.
     * @param codePostal    Le code postal de la société.
     * @param ville         La ville de la société.
     * @param telephone     Le numéro de téléphone de la société.
     * @param adresseMail   L'adresse email de la société.
     * @throws modelException Si une exception survient dans la couche modèle.
     */
    public Societe(int identifiant, String raisonSociale, String numeroRue, String nomRue, String codePostal,
                   String ville, String telephone, String adresseMail) throws modelException {
        setIdentifiant(identifiant);
        setRaisonSociale(raisonSociale);
        setNumeroRue(numeroRue);
        setNomRue(nomRue);
        setCodePostal(codePostal);
        setVille(ville);
        setTelephone(telephone);
        setAdresseMail(adresseMail);
    }

    /**
     * Récupère l'identifiant de la société.
     *
     * @return L'identifiant de la société.
     */
    public int getIdentifiant() {
        return identifiant;
    }

    /**
     * Définit l'identifiant de la société.
     *
     * @param identifiant L'identifiant de la société à définir.
     * @throws modelException Si l'identifiant est inférieur à zéro.
     */
    public void setIdentifiant(int identifiant) throws modelException {
        if (identifiant < 0) {
            throw new modelException("L'identifiant doit-être positif");
        }
        this.identifiant = identifiant;
    }

    /**
     * Récupère la raison sociale de la société.
     *
     * @return La raison sociale de la société.
     */
    public String getRaisonSociale() {
        return raisonSociale;
    }

    /**
     * Définit la raison sociale de la société.
     *
     * @param raisonSociale La raison sociale de la société à définir.
     * @throws modelException Si la raison sociale est nulle, vide ou dépasse 50 caractères.
     */
    public void setRaisonSociale(String raisonSociale) throws modelException {
        if (raisonSociale != null && !raisonSociale.isEmpty() && raisonSociale.length() <= 50) {
            this.raisonSociale = raisonSociale;
        } else {
            throw new modelException("La Raison social doit-être remplis");
        }
    }

    /**
     * Récupère le numéro de rue de la société.
     *
     * @return Le numéro de rue de la société.
     */
    public String getNumeroRue() {
        return numeroRue;
    }

    /**
     * Définit le numéro de rue de la société.
     *
     * @param numeroRue Le numéro de rue de la société à définir.
     * @throws modelException Si le numéro de rue est nul, vide ou dépasse 5 caractères.
     */
    public void setNumeroRue(String numeroRue) throws modelException {
        if (numeroRue == null || numeroRue.isEmpty() || numeroRue.length() > 5) {
            throw new modelException("Le numéro de rue doit-être remplis et inférieur à 5 caractère");
        }
        this.numeroRue = numeroRue;
    }

    /**
     * Récupère le nom de rue de la société.
     *
     * @return Le nom de rue de la société.
     */
    public String getNomRue() {
        return nomRue;
    }

    /**
     * Définit le nom de rue de la société.
     *
     * @param nomRue Le nom de rue de la société à définir.
     * @throws modelException Si le nom de rue est nul, vide ou dépasse 30 caractères.
     */
    public void setNomRue(String nomRue) throws modelException {
        if (nomRue == null || nomRue.isEmpty() || nomRue.length() > 30) {
            throw new modelException("Le nom de rue doit-être remplis");
        }
        this.nomRue = nomRue;
    }

    /**
     * Récupère le code postal de la société.
     *
     * @return Le code postal de la société.
     */
    public String getCodePostal() {
        return codePostal;
    }

    /**
     * Définit le code postal de la société.
     *
     * @param codePostal Le code postal de la société à définir.
     * @throws modelException Si le code postal est nul ou ne contient pas 5 caractères.
     */
    public void setCodePostal(String codePostal) throws modelException {
        if (codePostal == null || codePostal.length() != 5) {
            throw new modelException("Le code postal est incorrect");
        }
        this.codePostal = codePostal;
    }

    /**
     * Récupère la ville de la société.
     *
     * @return La ville de la société.
     */
    public String getVille() {
        return ville;
    }

    /**
     * Définit la ville de la société.
     *
     * @param ville La ville de la société à définir.
     * @throws modelException Si la ville est nulle, vide ou dépasse 45 caractères.
     */
    public void setVille(String ville) throws modelException {
        if (ville == null || ville.isEmpty() || ville.length() > 45) {
            throw new modelException("La ville est incorrect");
        }
        this.ville = ville;
    }

    /**
     * Récupère le numéro de téléphone de la société.
     *
     * @return Le numéro de téléphone de la société.
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Définit le numéro de téléphone de la société.
     *
     * @param telephone Le numéro de téléphone de la société à définir.
     * @throws modelException Si le numéro de téléphone est trop court.
     */
    public void setTelephone(String telephone) throws modelException {
        if (telephone != null && telephone.length() >= 10 && telephone.length() <= 20) {
            this.telephone = telephone;
        } else {
            throw new modelException("Le numéro est trop court, il faut au moins 10 chiffres");
        }
    }

    /**
     * Récupère l'adresse email de la société.
     *
     * @return L'adresse email de la société.
     */
    public String getAdresseMail() {
        return adresseMail;
    }

    /**
     * Définit l'adresse email de la société.
     *
     * @param adresseMail L'adresse email de la société à définir.
     * @throws modelException Si l'adresse email n'est pas valide.
     */
    public void setAdresseMail(String adresseMail) throws modelException {
        if (VerifMail.validMail(adresseMail)) {
            this.adresseMail = adresseMail;
        } else {
            throw new modelException("L'adresse mail n'est pas valide");
        }
    }

    /**
     * Récupère le commentaire sur la société.
     *
     * @return Le commentaire sur la société.
     */
    public String getCommentaire() {
        return commentaire;
    }

    /**
     * Définit le commentaire sur la société.
     *
     * @param commentaire Le commentaire sur la société à définir.
     */
    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    /**
     * Méthode toString pour afficher les informations de la société.
     *
     * @return Une chaîne de caractères représentant la société.
     */
    @Override
    public String toString() {
        return "Id : " + identifiant +
                ", raisonSociale : " + raisonSociale +
                ", numeroRue : " + numeroRue +
                ", nomRue : " + nomRue +
                ", codePostal : " + codePostal +
                ", ville : " + ville +
                ", telephone : " + telephone +
                ", adresseMail : " + adresseMail +
                ", commentaire : " + commentaire;
    }
}
