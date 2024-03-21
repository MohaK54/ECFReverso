package vue;

import controleur.ControleurAccueil;
import dao.daoException;
import model.modelException;
import utilities.MyLogg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 * Interface Utilisateur Principal (Accueil)
 */
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
        setTitle("Accueil");
        setContentPane(pBody);
        //setModal(true);
        setSize(1000, 800);

        btnCreateClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControleurAccueil.launchFormulaire("CreateC");
                dispose();
            }
            });
        btnCreer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControleurAccueil.launchFormulaire("CreateP");
                dispose();
            }
        });
        btnUpdateClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String raisSocial = JOptionPane.showInputDialog(ControleurAccueil.disp("Client").toArray());
                    if (raisSocial!=null){
                        ControleurAccueil.choiceClient(raisSocial);
                        ControleurAccueil.launchFormulaire("UpdateC");
                        dispose();
                    }

                } catch (daoException ex) {
                    if (ex.getLevel()==Level.SEVERE){
                        JOptionPane.showMessageDialog(null,"Oups, ce n'est pas vous, c'est nous!"
                                + "veuillez réessayer ultérieurement");
                        System.exit(1);
                    } else {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                    MyLogg.LOGGER.log(Level.SEVERE,ex.getMessage());
                    System.exit(1);
                }
            }
        });
        btnModif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String raisSocial = JOptionPane.showInputDialog(ControleurAccueil.disp("Prospect").toArray());
                    if(raisSocial!=null){
                        try {
                            ControleurAccueil.choiceProspect(raisSocial);
                        }catch (daoException de){
                            if (de.getLevel()==Level.SEVERE){
                                MyLogg.LOGGER.log(Level.SEVERE,de.getMessage());
                                JOptionPane.showMessageDialog(null,"Veuillez nous excuser" +
                                        " une erreur s'est produite");
                                System.exit(1);
                            }else {
                                JOptionPane.showMessageDialog(null,de.getMessage());
                            }
                        }catch (Exception ex){
                            MyLogg.LOGGER.log(Level.SEVERE,ex.getMessage());
                            JOptionPane.showMessageDialog(null,"Veuillez nous excuser" +
                                    " une erreur s'est produite");
                            System.exit(1);
                        }
                        ControleurAccueil.launchFormulaire("UpdateP");
                        dispose();
                    }
            }catch (daoException de){
                    if (de.getLevel()==Level.SEVERE){
                        MyLogg.LOGGER.log(Level.SEVERE,de.getMessage());
                        JOptionPane.showMessageDialog(null,"Veuillez nous excuser" +
                                " une erreur s'est produite");
                        System.exit(1);
                    }else {
                        JOptionPane.showMessageDialog(null,de.getMessage());
                    }
                }catch (Exception ex){
                    MyLogg.LOGGER.log(Level.SEVERE,ex.getMessage());
                    JOptionPane.showMessageDialog(null,"Veuillez nous excuser" +
                            " une erreur s'est produite");
                    System.exit(1);
                }
            }
        });
        btnDeleteClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String raisSocial = JOptionPane.showInputDialog(ControleurAccueil.disp("Client").toArray());
                    if(raisSocial!=null){
                        ControleurAccueil.choiceClient(raisSocial);
                        ControleurAccueil.launchFormulaire("DeleteC");
                        dispose();
                    }

                } catch (daoException ex) {
                    if (ex.getLevel()==Level.SEVERE){
                        JOptionPane.showMessageDialog(null,"Veuillez nous excuser, " +
                                "une erreur de notre côté");
                        MyLogg.LOGGER.log(Level.SEVERE,ex.getMessage());
                        System.exit(1);
                    }else {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }catch (Exception ex) {
                    MyLogg.LOGGER.log(Level.SEVERE, ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Veuillez nous excuser" +
                            " une erreur s'est produite");
                    System.exit(1);
                }
            }
        });
        btnSupp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String raisSocial = JOptionPane.showInputDialog(ControleurAccueil.disp("Prospect").toArray());
                    if (raisSocial != null) {
                        ControleurAccueil.choiceProspect(raisSocial);
                        ControleurAccueil.launchFormulaire("DeleteP");
                        dispose();
                    }
                } catch (daoException ex) {
                    if (ex.getLevel()==Level.SEVERE){
                        JOptionPane.showMessageDialog(null,"Veuillez nous excuser, " +
                                "une erreur de notre côté");
                        MyLogg.LOGGER.log(Level.SEVERE,ex.getMessage());
                        System.exit(1);
                    }else {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }catch (Exception ex) {
                    MyLogg.LOGGER.log(Level.SEVERE, ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Veuillez nous excuser" +
                            " une erreur s'est produite");
                    System.exit(1);
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
                ControleurAccueil.launchAffichage("Prospect");
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
                ControleurAccueil.launchAffichage("Client");
                dispose();

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

