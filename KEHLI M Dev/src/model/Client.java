package model;




public class Client extends Societe {
    private double chiffreAffaire;
    private int  nbrEmploye ;
    public Client(int id,
                  String raisonSociale,
                  String numeroRue,
                  String nomRue,
                  String codePostal,
                  String ville,
                  String telephone,
                  String adresseMail,
                  String commentaire,
                  double chiffreAffaire,
                  int nbrEmploye
    ) throws modelException {
        super(id, raisonSociale, numeroRue, nomRue, codePostal, ville, telephone, adresseMail, commentaire);
        this.setChiffreDaffaire(chiffreAffaire);
        System.out.println(this.chiffreAffaire);
        System.out.println(getChiffreAffaire());
        this.setNombreEmployer(nbrEmploye);
    }

    public Client(int id,
                  String raisonSociale,
                  String numeroRue,
                  String nomRue,
                  String codePostal,
                  String ville,
                  String telephone,
                  String adresseMail,
                  double chiffreAffaire,
                  int nbrEmploye
    ) throws modelException {
        super(id, raisonSociale, numeroRue, nomRue, codePostal, ville, telephone, adresseMail);
        this.setChiffreDaffaire(chiffreAffaire);
        System.out.println(this.chiffreAffaire);
        System.out.println(getChiffreAffaire());
        this.setNombreEmployer(nbrEmploye);
    }


    public double getChiffreAffaire() {
        return this.chiffreAffaire;
    }

    public void setChiffreDaffaire(double chiffreAffaire) throws modelException {
        if (chiffreAffaire<=200){
            throw new modelException("Le chiffre d’affaires doit être supérieur à 200");
        }
        this.chiffreAffaire = chiffreAffaire;
    }

    public int getNbrEmploye() {
        return this.nbrEmploye;
    }

    public void setNombreEmployer(int nbrEmploye) throws modelException {
        if (nbrEmploye < 1){
            throw new modelException("Le nombre d’employés doit être strictement supérieur à 0");

        }
            this.nbrEmploye = nbrEmploye;
    }

    @Override
    public String toString() {
        return super.toString()+ "Client{" +
                "chiffreDaffaire=" + chiffreAffaire +
                ", nombreEmployer=" + nbrEmploye +
                '}';
    }
}