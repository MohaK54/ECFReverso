package controleur;

import dao.DaoClient;
import dao.daoException;
import model.modelException;
import vue.Accueil;
import vue.Affichage;

import java.io.IOException;
import java.sql.SQLException;

public class ControleurAccueil {
    private static final Accueil accueil = new Accueil();
    public static void init() {
        accueil.setVisible(true);
    }


}
