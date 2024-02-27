package model;

import java.util.Date;

public class Prospect extends Societe {

    private Date dateProspection;
    private String interet;


    public Prospect(int identifiant, String raisonSociale, String numeroRue,
                    String nomRue, String codePostal,
                    String ville, String telephone,
                    String adresseMail, String commentaire,
                    Date dateProspection, String interet) throws modelException {
        super(identifiant, raisonSociale, numeroRue, nomRue, codePostal, ville, telephone, adresseMail, commentaire);
        setDateProspection(dateProspection);
        setInteret(interet);
    }

    public Prospect(int identifiant, String raisonSociale, String numeroRue, String nomRue, String codePostal,
                    String ville, String telephone, String adresseMail,
                    Date dateProspection, String interet) throws modelException {
        super(identifiant, raisonSociale, numeroRue, nomRue, codePostal, ville, telephone, adresseMail);
        setDateProspection(dateProspection);
        setInteret(interet);
    }

    public Date getDateProspection() {
        return dateProspection;
    }

    public void setDateProspection(Date dateProspection) {
        this.dateProspection = dateProspection;
    }

    public String getInteret() {
        return interet;
    }

    public void setInteret(String interet) {
        this.interet = interet;
    }
}
