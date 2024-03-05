package controleur;

import dao.DaoClient;
import dao.DaoProspect;
import dao.daoException;
import model.Client;
import model.Prospect;
import model.modelException;
import vue.Accueil;
import vue.Affichage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControleurAccueil {
    private static final Accueil accueil = new Accueil();
    public static void init() {
        accueil.setVisible(true);
    }


    public static ArrayList<String> disp(String entity) throws SQLException, IOException, daoException, modelException {
        if (entity.equals("Client"))
        {
            ArrayList<String> dispName = DaoClient.findAllRS();
            return dispName;
        } else {
            ArrayList<String> dispName = DaoProspect.findAllRS();
            return dispName;
        }

    }



    public static Client findClient(String nom) throws SQLException, IOException, daoException, modelException {
        Client client = DaoClient.findByName(nom);
        return client;
    }

    public static Prospect findProspect(String nom) throws SQLException, IOException, daoException, modelException {
        Prospect prospect = DaoProspect.findByName(nom);
        return prospect;
    }

    public static void launchFormulaire(String option) throws SQLException, IOException, daoException, modelException {
        ControleurFormulaire.init(option);
    }

    public static void launchAffichage(String option) throws SQLException, IOException, daoException, modelException {
        ControleurAffichage.init(option);
    }

    public static void choiceClient(String raisonSocial) throws SQLException, IOException, daoException, modelException {
        ControleurFormulaire.selecClient(findClient(raisonSocial));
    }

    public static void choiceProspect(String raisonSocial) throws SQLException, IOException, daoException, modelException {
        ControleurFormulaire.selectProspect(findProspect(raisonSocial));
    }

}
