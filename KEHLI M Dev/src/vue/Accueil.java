package vue;

import controleur.ControleurAffichage;
import dao.daoException;
import model.modelException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class Accueil extends JDialog {

    private JPanel jpTete;
    private JLabel lbTitre;
    private JPanel jpCorps;
    private JButton btnClient;
    private JButton btnProspect;
    private JPanel pBody;
    private JPanel jpCorps2;
    private JButton btnCreer;
    private JButton btnSupp;
    private JButton btnModif;
    private JButton btnAffichage;
    private JPanel jpCorps0;
    private JButton btnRetour;
    private JPanel jpCorps1;
    private JButton btnCreateClient;
    private JButton btnFindAllClient;
    private JButton btnUpdateClient;
    private JButton btnDeleteClient;

    public Accueil() {
        setContentPane(pBody);
        //setModal(true);
        setSize(1600, 1000);
    }
    {
        jpCorps2.setVisible(false);
        jpCorps1.setVisible(false);
        btnRetour.setVisible(false);


        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpCorps2.setVisible(false);
                jpCorps1.setVisible(false);
                jpCorps0.setVisible(true);
                btnRetour.setVisible(false);
            }
        });
        btnFindAllClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    ControleurAffichage.init("Client");
                    dispose();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (daoException ex) {
                    throw new RuntimeException(ex);
                } catch (modelException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnProspect.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            jpCorps0.setVisible(false);
            jpCorps2.setVisible(true);
            btnRetour.setVisible(true);
        }
    });
        btnClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpCorps0.setVisible(false);
                jpCorps2.setVisible(false);
                jpCorps1.setVisible(true);
                btnRetour.setVisible(true);
            }
        });


    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

