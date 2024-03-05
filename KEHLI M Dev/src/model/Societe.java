package model;

public abstract class  Societe {

    private int identifiant;
    private static int nextId = 1;
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
        nextId++;
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

    public void setIdentifiant(int identifiant) throws modelException {
        if (identifiant < 0 ){
            throw new modelException("L'identifiant doit-être positif");
        }
        this.identifiant = identifiant;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) throws modelException {
        if (raisonSociale!= null && !raisonSociale.isEmpty() && raisonSociale.length() <= 50){
            this.raisonSociale = raisonSociale;
        } else {
            throw new modelException("La Raison social doit-être remplis");
        }
    }

    public String getNumeroRue() {
        return numeroRue;
    }

    public void setNumeroRue(String numeroRue) throws modelException {
        if (numeroRue==null || numeroRue.isEmpty() || numeroRue.length()>5){
            throw new modelException("Le numéro de rue doit-être remplis et inférieur à 5 caractère");
        }
        this.numeroRue = numeroRue;
    }

    public String getNomRue() {
        return nomRue;
    }

    public void setNomRue(String nomRue) throws modelException {
        if (nomRue==null || nomRue.isEmpty() || nomRue.length() > 30){
            throw new modelException("Le nom de rue doit-être remplis");
        }
        this.nomRue = nomRue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) throws modelException {
        if (codePostal==null || codePostal.length()!=5){
            throw new modelException("Le code postal est incorrect");
        }
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) throws modelException {
        if (ville == null || ville.isEmpty() || ville.length() > 45){
            throw new modelException("La ville est incorrect");
        }
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) throws modelException {
        if (telephone!=null && telephone.length()>=10 && telephone.length()<=20){
            this.telephone = telephone;
        } else {
            throw new modelException("le numéro est trop court il faut au moins 10 chiffres");
        }

    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) throws modelException {
        if (adresseMail!=null && adresseMail.matches(".*@.*")) {
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
                ", raisonSociale : " + raisonSociale +
                ", numeroRue : " + numeroRue +
                ", nomRue : " + nomRue +
                ", codePostal : " + codePostal +
                ", ville : " + ville +
                ", telephone : " + telephone +
                ", adresseMail : " + adresseMail +
                ", commentaire : " + commentaire  ;
    }
}
