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

public class ControleurAffichage {

    public static void init(String entity) throws SQLException, IOException, daoException, modelException {
        Affichage affichage = new Affichage(entity);
        affichage.setVisible(true);
    }

    public static ArrayList findAllClient() throws SQLException, IOException, daoException, modelException {
        return DaoClient.findAll();
    }
    public static ArrayList findAllProspect() throws SQLException, IOException, daoException, modelException {
        return DaoProspect.findAll();
    }
}
