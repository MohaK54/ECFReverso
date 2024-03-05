package application;

import controleur.ControleurAccueil;
import dao.Connexion;
import dao.DaoClient;
import dao.DaoProspect;
import dao.daoException;
import model.Client;
import model.Prospect;
import model.modelException;
import utilities.FormatLog;
import utilities.MyLogg;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.FileHandler;
import java.util.logging.Level;

public class Main {
    private static FileHandler fl = null;

    public static void main(String[] args) throws modelException, SQLException, IOException, daoException {
        fl = new FileHandler("FichierLog.log",true);
        fl.setFormatter(new FormatLog());
        MyLogg.LOGGER.setUseParentHandlers(false);
        MyLogg.LOGGER.addHandler(fl);
        MyLogg.LOGGER.log(Level.INFO,"Début du programme");
        ControleurAccueil.init();
        MyLogg.LOGGER.log(Level.INFO,"Fin du programme");
    }
}
