package controleur;

import dao.DaoClient;
import dao.DaoProspect;
import dao.daoException;
import model.Client;
import model.Prospect;
import model.modelException;
import vue.Formulaire;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;


public class ControleurFormulaire {
    public static Client clientSelect;
    public static Prospect prospectSelect;

    public static void init(String entity) throws SQLException, IOException, daoException, modelException {
        Formulaire formulaire = new Formulaire(entity);
        formulaire.setVisible(true);

    }

    public static void creerClient(
                             int id,
                             String rs,
                             String numRue,
                             String nomRue,
                             String ville,
                             String cp,
                             String tel,
                             String mail,
                             String comm,
                             double ca,
                             int nbrEmploye) throws Exception {
        Client client = new Client(id,rs,numRue,nomRue,cp,ville,tel,mail,comm,ca,nbrEmploye);
        DaoClient.create(client);
    }

    public static void creerProspect(
            int id,
            String rs,
            String numRue,
            String nomRue,
            String ville,
            String cp,
            String tel,
            String mail,
            String comm,
            String interet,
            LocalDate date) throws Exception {
        boolean interesse = false;
        if (interet.equals("oui"))
        {
            interesse = true;
        }
        Prospect prospect = new Prospect(id,rs,numRue,nomRue,cp,ville,tel,mail,comm,date,interesse);
        DaoProspect.create(prospect);
    }

    public static void selecClient(Client client){
         clientSelect = client;
    }
    public static void selectProspect(Prospect prospect){
        prospectSelect = prospect;
    }

    public static void updateClient(int id,
                                    String rs,
                                    String numRue,
                                    String nomRue,
                                    String ville,
                                    String cp,
                                    String tel,
                                    String mail,
                                    String comm,
                                    double ca,
                                    int nbrEmploye) throws Exception {
        Client client = new Client(id,rs,numRue,nomRue,cp,ville,tel,mail,comm,ca,nbrEmploye);
        DaoClient.update(client);
    }
    public static void updateProspect(
            int id,
            String rs,
            String numRue,
            String nomRue,
            String ville,
            String cp,
            String tel,
            String mail,
            String comm,
            String interet,
            LocalDate date) throws Exception {
        boolean interesse = false;
        if (interet.equals("oui"))
        {
            interesse = true;
        }
        Prospect prospect = new Prospect(id,rs,numRue,nomRue,cp,ville,tel,mail,comm,date,interesse);
        DaoProspect.update(prospect);
    }

    public static void deleteClient(int id) throws Exception {
        DaoClient.delete(id);
    }
    public static void deleteProspect(int id) throws Exception {
        DaoProspect.delete(id);
    }
    public static void launchAccueil(){
        ControleurAccueil.init();
    }

}
