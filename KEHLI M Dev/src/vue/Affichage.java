package vue;

import controleur.ControleurAccueil;
import controleur.ControleurAffichage;
import dao.daoException;
import model.Client;
import model.Prospect;
import model.modelException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class Affichage extends JDialog {

    private JPanel jBody;
    private JTable listeA;
    private JButton btn;
    private JScrollPane JSPliste;
    private JPanel JBody;

    public Affichage(String entity) throws SQLException, IOException, daoException, modelException {
        setTitle("Affichage");
        setContentPane(jBody);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocationRelativeTo(null);
        btn.setVisible(true);

        if (entity.equals("Client")) {
            ArrayList<Client> liste = ControleurAffichage.findAllClient();
            Object[][] data = new Object[liste.size()][11];
            for (int i = 0; i < liste.size(); i++) {
                Client client = liste.get(i);
                data[i][0] = client.getIdentifiant();
                data[i][1] = client.getRaisonSociale();
                data[i][2] = client.getNumeroRue();
                data[i][3] = client.getNomRue();
                data[i][4] = client.getVille();
                data[i][5] = client.getCodePostal();
                data[i][6] = client.getTelephone();
                data[i][7] = client.getAdresseMail();
                data[i][8] = client.getCommentaire();
                data[i][9] = client.getChiffreAffaire();
                data[i][10] = client.getNbrEmploye();
            }
            String[] columnNames = {"identifiant","Raison Social","Num Rue", "Nom Rue",
                    "Ville", "Code Postal", "num Tel", "Adresse mail", "Commentaire" ,"Chiffre d'affaire",
                    "Nombre d'employé"};
            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            listeA.setModel(model);
            JSPliste.setViewportView(listeA);
            JBody.setVisible(true);
            JSPliste.setVisible(true);
            listeA.setVisible(true);
        }
        else if (entity.equals("Prospect")) {
            ArrayList<Prospect> liste = ControleurAffichage.findAllProspect();
            Object[][] data = new Object[liste.size()][11];
            for (int i = 0; i < liste.size(); i++) {
                Prospect prospect = liste.get(i);
                data[i][0] = prospect.getIdentifiant();
                data[i][1] = prospect.getRaisonSociale();
                data[i][2] = prospect.getNumeroRue();
                data[i][3] = prospect.getNomRue();
                data[i][4] = prospect.getVille();
                data[i][5] = prospect.getCodePostal();
                data[i][6] = prospect.getTelephone();
                data[i][7] = prospect.getAdresseMail();
                data[i][8] = prospect.getDateProspection();
                data[i][9] = prospect.getInteret();
                data[i][10] = prospect.getCommentaire();
            }
            String[] columnNames = { "identifiant", "Raison Social","Num Rue", "Nom Rue",
                    "Ville","Code Postal","num Tel","Adresse mail","Date Prospection","Interet ?",
                    "Commentaire" };
            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            listeA.setModel(model);
            JSPliste.setViewportView(listeA);
            JBody.setVisible(true);
            JSPliste.setVisible(true);
            listeA.setVisible(true);
        }
    }

    {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControleurAccueil.init();
                dispose();
            }
        });
    }


    private void createUIComponents() {

    }
}



