package model;

public class Client extends Societe {

    private double chiffreAffaire;
    private int nbrEmploye;
    public Client(int identifiant, String raisonSociale, String numeroRue,
                  String nomRue, String codePostal,
                  String ville, String telephone, String adresseMail,
                  String commentaire, double chiffreAffaire, int nbrEmploye) throws modelException {
        super(identifiant, raisonSociale, numeroRue, nomRue, codePostal, ville, telephone, adresseMail, commentaire);
        setChiffreAffaire(chiffreAffaire);
        setNbrEmploye(nbrEmploye);
    }

    public Client(int identifiant, String raisonSociale, String numeroRue,
                  String nomRue, String codePostal,
                  String ville, String telephone,
                  String adresseMail, double chiffreAffaire, int nbrEmploye) throws modelException {
        super(identifiant, raisonSociale, numeroRue, nomRue, codePostal, ville, telephone, adresseMail);
    }

    public double getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(double chiffreAffaire) throws modelException {
        if (chiffreAffaire<=200){
            throw new modelException("le chiffre d'affaire n'est pas correct");
        }
        this.chiffreAffaire = chiffreAffaire;
    }

    public int getNbrEmploye() {
        return nbrEmploye;
    }

    public void setNbrEmploye(int nbrEmploye) throws modelException {
        if (nbrEmploye<=0){
            throw new modelException("le nombre d'employé doit être supérieur à 0");
        }
        this.nbrEmploye = nbrEmploye;
    }

    @Override
    public String toString() {
        return super.toString()  +
                " C.A : " + chiffreAffaire +
                ", Nbr d'Employe : " + nbrEmploye;
    }
}
