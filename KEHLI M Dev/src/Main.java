import dao.Connexion;
import dao.DaoClient;
import model.Prospect;
import model.modelException;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {


    public static void main(String[] args) throws modelException {


        Prospect prospect = new Prospect(1,"youyou","15","rue",
                "93000","nan","1234567890","momo@momo.fr","ggg",
                "2001/08/19",true);

        System.out.println(prospect);

        try (Connection connection = Connexion.getInstance()) {

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
    }
}
