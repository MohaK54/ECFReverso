package model;

public abstract class  Societe {

    private int identifiant;
    private String raisonSociale;
    private String numeroRue;
    private String nomRue;
    private String codePostal;
    private String ville;
    private String telephone;
    private String adresseMail;
    private String commentaire;

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

    public int getIdentifiant() {

        return identifiant;
    }

    public void setIdentifiant(int identifiant) {

        this.identifiant = identifiant;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getNumeroRue() {
        return numeroRue;
    }

    public void setNumeroRue(String numeroRue) {
        this.numeroRue = numeroRue;
    }

    public String getNomRue() {
        return nomRue;
    }

    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) throws modelException {
        if (telephone.length()>=10){
            this.telephone = telephone;
        } else {
            throw new modelException("le numéro est trop court il faut au moins 10 chiffres");
        }

    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) throws modelException {
        if (adresseMail.matches(".*@.*")) {
            this.adresseMail = adresseMail;
        }
        else{
        throw new modelException("l'adresse mail n'est pas valide");
    }

    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return
                "Id : " + identifiant +
                ", raisonSociale : " + raisonSociale + '\'' +
                ", numeroRue : " + numeroRue + '\'' +
                ", nomRue : " + nomRue + '\'' +
                ", codePostal : " + codePostal + '\'' +
                ", ville : " + ville + '\'' +
                ", telephone : " + telephone + '\'' +
                ", adresseMail : " + adresseMail + '\'' +
                ", commentaire : " + commentaire + '\'' ;
    }
}
