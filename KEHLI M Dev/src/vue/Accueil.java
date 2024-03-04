package vue;

import controleur.ControleurAccueil;
import controleur.ControleurAffichage;
import controleur.ControleurFormulaire;
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
        setSize(1000, 800);

        btnCreateClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ControleurFormulaire.init("Client");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (daoException ex) {
                    throw new RuntimeException(ex);
                } catch (modelException ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
            }
        });
        btnCreer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ControleurFormulaire.init("CreateP");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (daoException ex) {
                    throw new RuntimeException(ex);
                } catch (modelException ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
            }
        });
        btnUpdateClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String raisSocial = JOptionPane.showInputDialog(ControleurAccueil.disp("Client").toArray());
                    if (raisSocial!=null){
                        ControleurFormulaire.selecClient(ControleurAccueil.findClient(raisSocial));
                        ControleurFormulaire.init("UpdateC");
                        dispose();
                    }

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
        btnModif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String raisSocial = JOptionPane.showInputDialog(ControleurAccueil.disp("Prospect").toArray());
                    if(raisSocial!=null){
                        ControleurFormulaire.selectProspect(ControleurAccueil.findProspect(raisSocial));
                        ControleurFormulaire.init("UpdateP");
                        dispose();
                    }

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
    }
    {
        jpCorps2.setVisible(false);
        jpCorps1.setVisible(false);
        btnRetour.setVisible(false);
        btnAffichage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ControleurAffichage.init("Prospect");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (daoException ex) {
                    throw new RuntimeException(ex);
                } catch (modelException ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
            }
        });

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

