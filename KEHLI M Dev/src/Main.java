import dao.Connexion;
import dao.DaoClient;
import model.Prospect;
import model.modelException;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {


    public static void main(String[] args) throws modelException {




        try {
            // 1 - utilisateur rentre une date
            String dateUser = JOptionPane.showInputDialog("rentrez une date");

            // 2 - je créer un format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            // 3 - je cree une date avec la date de l'user + mon format
            LocalDate date = LocalDate.parse(dateUser, formatter);


            Prospect prospect = new Prospect(1,"youyou","15","rue",
                            "93000","nan","1234567890","momo@momo.fr","ggg",
                            date,true);
            System.out.println(prospect);

            Connection connection = Connexion.getInstance();
            if (connection != null && !connection.isClosed()) {
                System.out.println(" bravo, félicitation, tu as enfin réussi ! bravo champion je suis fier de toi " +
                        " tu mérite ce : succes connection");
            } else {
                System.out.println(" mazzaaaaal ya l'hmaaar ");
            }

            //DaoClient daoClient = new DaoClient();

            JOptionPane.showMessageDialog(null,DaoClient.findAll().toArray());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (modelException me){
            System.out.println("erreur model"+me.getMessage());
        }catch (DateTimeParseException dte){
            System.out.println("erreur date " + dte.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
