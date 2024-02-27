package model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Prospect extends Societe {

    private LocalDate dateProspection;
    private String interet;


    public Prospect(int identifiant, String raisonSociale, String numeroRue,
                    String nomRue, String codePostal,
                    String ville, String telephone,
                    String adresseMail, String commentaire,
                    String dateProspection, Boolean interesse) throws modelException {
        super(identifiant, raisonSociale, numeroRue, nomRue, codePostal, ville, telephone, adresseMail, commentaire);
        setDateProspection(dateProspection);
        setInteret(interesse);
    }

    public Prospect(int identifiant, String raisonSociale, String numeroRue, String nomRue, String codePostal,
                    String ville, String telephone, String adresseMail,
                    String dateProspection, Boolean interesse) throws modelException {
        super(identifiant, raisonSociale, numeroRue, nomRue, codePostal, ville, telephone, adresseMail);
        setDateProspection(dateProspection);
        setInteret(interesse);
    }

    public LocalDate getDateProspection() {
        return dateProspection;
    }

    public void setDateProspection(LocalDate dateProspection) throws modelException {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        this.dateProspection = dateProspection;
    }




    public String getInteret() {
        return interet;
    }

    public void setInteret(Boolean interesse) {
        if (interesse){
            this.interet = "oui";
        } else {
            this.interet = "non";
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Prospect{" +
                "dateProspection=" + dateProspection +
                ", interet='" + interet + '\'' +
                '}';
    }
}
