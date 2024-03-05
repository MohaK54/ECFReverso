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
        setTitle("Accueil");
        setContentPane(pBody);
        //setModal(true);
        setSize(1000, 800);

        btnCreateClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ControleurFormulaire.init("CreateC");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (daoException ex) {
                    throw new RuntimeException(ex);
                } catch (modelException ex) {
                    throw new RuntimeException(ex);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
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
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
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

                } catch (modelException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                } catch (daoException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
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

                } catch (modelException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                } catch (daoException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        btnDeleteClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String raisSocial = JOptionPane.showInputDialog(ControleurAccueil.disp("Client").toArray());
                    if(raisSocial!=null){
                        ControleurFormulaire.selecClient(ControleurAccueil.findClient(raisSocial));
                        ControleurFormulaire.init("DeleteC");
                        dispose();
                    }

                } catch (modelException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                } catch (daoException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        btnSupp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String raisSocial = JOptionPane.showInputDialog(ControleurAccueil.disp("Prospect").toArray());
                    if (raisSocial != null) {
                        ControleurFormulaire.selectProspect(ControleurAccueil.findProspect(raisSocial));
                        ControleurFormulaire.init("DeleteP");
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
                } catch (modelException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                } catch (daoException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
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
                } catch (modelException | daoException | SQLException | IOException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
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

