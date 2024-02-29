package vue;

import dao.daoException;
import model.Client;
import model.modelException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class Affichage extends JFrame {

    private JPanel jBody;
    private JTable listeA;

    public Affichage(ArrayList<Client> liste) throws SQLException, IOException, daoException, modelException {
        setTitle("Liste des Clients");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        Object[][] data = new Object[liste.size()][11];
        for (int i = 0; i < liste.size(); i++) {
            Client client = liste.get(i);
            data[i][0] = client.getIdentifiant();
            data[i][1] = client.getRaisonSociale();
            data[i][3] = client.getNumeroRue();
            data[i][4] = client.getNomRue();
            data[i][5] = client.getVille();
            data[i][6] = client.getCodePostal();
            data[i][7] = client.getTelephone();
            data[i][8] = client.getAdresseMail();
            data[i][9] = client.getChiffreAffaire();
            data[i][10] = client.getNbrEmploye();
        }
        String[] columnNames = {"Nom", "Âge", "Ville","","","","","","","",""};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);





    }
}



