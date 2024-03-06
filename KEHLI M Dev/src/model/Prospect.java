package model;

import utilities.DateFormat;

import java.time.LocalDate;

public class Prospect extends Societe {

    private LocalDate dateProspection;
    private String interet;
    public Prospect(){}


    public Prospect(int identifiant, String raisonSociale, String numeroRue,
                    String nomRue, String codePostal,
                    String ville, String telephone,
                    String adresseMail, String commentaire,
                    LocalDate dateProspection, String interet) throws modelException {
        super(identifiant, raisonSociale, numeroRue, nomRue, codePostal, ville, telephone, adresseMail, commentaire);
        setDateProspection(dateProspection);
        setInteret(interet);
    }

    public Prospect(int identifiant, String raisonSociale, String numeroRue, String nomRue, String codePostal,
                    String ville, String telephone, String adresseMail,
                    LocalDate dateProspection, String interet) throws modelException {
        super(identifiant, raisonSociale, numeroRue, nomRue, codePostal, ville, telephone, adresseMail);
        setDateProspection(dateProspection);
        setInteret(interet);
    }

    public LocalDate getDateProspection() {
        return this.dateProspection;
    }

    public void setDateProspection(LocalDate dateProspection) throws modelException {
        if (dateProspection==null){
            throw new modelException("La date doit-être remplis");
        }
        this.dateProspection = dateProspection;
    }




    public String getInteret() {
        return interet;
    }

    public void setInteret(String interet) throws modelException {
        if (interet==null || !interet.equals("oui") && !interet.equals("non")){
            throw new modelException("l'interet n'est pas claire");
        }
        this.interet=interet;
    }

    @Override
    public String toString() {
        return super.toString() +
                " date de Prospection : " + DateFormat.formatDate(getDateProspection()) +
                ", interet : " + interet + '\'' ;
    }
}
