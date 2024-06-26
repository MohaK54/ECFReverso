package vue;


import controleur.ControleurAffichage;
import dao.daoException;
import model.Client;
import model.Prospect;
import model.modelException;
import utilities.DateFormat;
import utilities.MyLogg;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;

/**
 * Interface Utilisateur pour afficher les Clients ou Prospects
 */
public class Affichage extends JDialog {

    private JPanel jBody;
    private JTable listeA;
    private JButton btn;
    private JScrollPane JSPliste;
    private JPanel JBody;

    public Affichage(String entity) {
        setTitle("Affichage");
        setContentPane(jBody);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        btn.setVisible(true);

        try {
            if (entity.equals("Client")) {
            ArrayList<Client> liste = ControleurAffichage.findAllClient();
                liste.sort(Comparator.comparing(Client::getRaisonSociale));
            Object[][] data = new Object[liste.size()][10];
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
                data[i][8] = client.getChiffreAffaire();
                data[i][9] = client.getNbrEmploye();
            }
            String[] columnNames = {"identifiant", "Raison Social", "Num Rue", "Nom Rue",
                    "Ville", "Code Postal", "num Tel", "Adresse mail", "Chiffre d'affaire",
                    "Nombre d'employé"};

            DefaultTableModel model = new DefaultTableModel(data, columnNames);

            listeA.setModel(model);



            } else if (entity.equals("Prospect")) {
            ArrayList<Prospect> liste = ControleurAffichage.findAllProspect();
                liste.sort(Comparator.comparing(Prospect::getRaisonSociale));
            Object[][] data = new Object[liste.size()][10];

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
                data[i][8] = DateFormat.formatDate(prospect.getDateProspection());
                data[i][9] = prospect.getInteret();
            }

            String[] columnNames = {"identifiant", "Raison Social", "Num Rue", "Nom Rue",
                    "Ville", "Code Postal", "num Tel", "Adresse mail", "Date Prospection", "Interet ?"};


            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            listeA.setModel(model);
        }
    }catch (daoException ex) {
            if (ex.getLevel()==Level.SEVERE){
                MyLogg.LOGGER.log(Level.SEVERE,ex.getMessage());
                JOptionPane.showMessageDialog(null,"Oups, ce n'est pas vous, c'est nous ! "
                        + "veuillez réessayer ultérieurement");
                System.exit(1);
            } else {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Oups, ce n'est pas vous, c'est nous ! "
                    + "veuillez réessayer ultérieurement");
            MyLogg.LOGGER.log(Level.SEVERE,ex.getMessage());
            System.exit(1);
        }
    }

    {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControleurAffichage.launchAccueil();
                dispose();
            }
        });
    }

    private void createUIComponents() {

    }
}



