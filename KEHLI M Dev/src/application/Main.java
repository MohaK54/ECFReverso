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


          try {


              fl = new FileHandler("FichierLog.log",true);
              fl.setFormatter(new FormatLog());
              MyLogg.LOGGER.setUseParentHandlers(false);
              MyLogg.LOGGER.addHandler(fl);
              MyLogg.LOGGER.log(Level.INFO,"Début du programme");
              Connection connection = Connexion.getInstance();
              if (connection != null && !connection.isClosed()) {
                  System.out.println(" bravo, félicitation, tu as enfin réussi ! bravo champion je suis fier de toi " +
                          " tu mérite ce : succes connection");
              } else {
                  System.out.println(" mazzaaaaal ya l'hmaaar ");
              }

              ControleurAccueil.init();
              // 1 - utilisateur rentre une date
           // String dateUser = "19/08/2001";

            // 2 - je créer un format
            //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            // 3 - je cree une date avec la date de l'user + mon format
            //LocalDate date = LocalDate.parse(dateUser, formatter);

           // Prospect prospect = new Prospect(1, "LG", "15", "rue",
           //         "93000", "nancy", "1234567890", "you@you.fr", "pas mal",
           //         date, true);
           // System.out.println(prospect);



            //JOptionPane.showMessageDialog(null, DaoClient.findAll().toArray());
           // JOptionPane.showMessageDialog(null, DaoClient.findByName("Ibrahim Industrie"));

           //   Client client = new Client(18, "LG", "15b",
             //         "Village de la Chapelenie", "35160",
                   //   "Montfort-Sur-Meu", "0781770148", "adresse@mail.com",
               //       2500,
                 //     500);

             // DaoProspect.create(prospect);
              //DaoProspect.update(prospect);
             // JOptionPane.showMessageDialog(null,client.getIdentifiant());
              //JOptionPane.showMessageDialog(null, DaoProspect.findAll().toArray());

           // DaoClient.update(client);
            //DaoClient.delete(21);

           // DaoClient.create(client);

            MyLogg.LOGGER.log(Level.INFO,"Fin du programme");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
      //  catch (modelException me){
       //     System.out.println("erreur model "+me.getMessage());
       // }
        catch (DateTimeParseException dte){
            System.out.println("erreur date " + dte.getMessage());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
       // catch (daoException e) {
       //     System.out.println("erreur dao " + e.getMessage());;
       // }
    }
}
