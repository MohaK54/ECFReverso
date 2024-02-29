package controleur;

import dao.DaoClient;
import dao.daoException;
import model.Client;
import model.modelException;
import vue.Accueil;
import vue.Affichage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControleurAffichage {

    public static void init(String entity) throws SQLException, IOException, daoException, modelException {
        ArrayList<Client> listeClients = DaoClient.findAll();
        Affichage affichage = new Affichage(listeClients);
    }

    public static void findAllClient() throws SQLException, IOException, daoException, modelException {

    }
}
