import dao.Connexion;
import dao.DaoClient;
import dao.daoException;
import model.Client;
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


    public static void main(String[] args) throws modelException, SQLException, IOException, daoException {


          try {
           // 1 - utilisateur rentre une date
            String dateUser = "19/08/2001";

            // 2 - je créer un format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            // 3 - je cree une date avec la date de l'user + mon format
            LocalDate date = LocalDate.parse(dateUser, formatter);


            Prospect prospect = new Prospect(1, "youyou", "15", "rue",
                    "93000", "nan", "1234567890", "momo@momo.fr", "ggg",
                    date, true);
            System.out.println(prospect);

            Connection connection = Connexion.getInstance();
            if (connection != null && !connection.isClosed()) {
                System.out.println(" bravo, félicitation, tu as enfin réussi ! bravo champion je suis fier de toi " +
                        " tu mérite ce : succes connection");
            } else {
                System.out.println(" mazzaaaaal ya l'hmaaar ");
            }

            Client client = new Client(3, "can20", "7",
                    "rue Paul Jacques", "13000",
                    "Marseille", "0781770148", "adresse@mail.com", "test",
                    2500,
                    500);
            Client client1 = new Client(4, "boulangerie2", "5", "avenur de l'europe",
                "57600", "Forbach", "0123456789", "boulangerie@mail.com",
                500000, 23000);
            JOptionPane.showMessageDialog(null, DaoClient.findAll().toArray());
            JOptionPane.showMessageDialog(null, DaoClient.findByName("Ibrahim Industrie"));


            DaoClient.create(client1);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (modelException me){
            System.out.println("erreur model "+me.getMessage());
        }
        catch (DateTimeParseException dte){
            System.out.println("erreur date " + dte.getMessage());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (daoException e) {
            System.out.println("erreur dao " + e.getMessage());;
        }
    }
}
