package vue;

import controleur.ControleurAccueil;
import controleur.ControleurFormulaire;
import dao.daoException;
import model.modelException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Formulaire extends JDialog {
    private JPanel panel;
    private JPanel JPlabel;
    private JPanel JPsaisi;
    private JPanel JPmain;
    private JTextField sId;
    private JTextField sRS;
    private JTextField sExtra1;
    private JTextField sNumRue;
    private JTextField sNomRue;
    private JTextField sVille;
    private JTextField sCom;
    private JTextField sCP;
    private JTextField sTel;
    private JTextField sMail;
    private JLabel lbIdent;
    private JLabel lbRS;
    private JLabel lbNumRue;
    private JLabel lnNomRue;
    private JLabel lbVille;
    private JLabel lbCP;
    private JLabel lbTel;
    private JLabel lbMail;
    private JLabel lbCom;
    private JLabel lbExtra1;
    private JLabel lbExtra2;
    private JTextField sExtra2;
    private JButton btnCreer;
    private JButton btnAccueil;
    private JPanel JPbtn;
    private JPanel JPTitle;
    private JLabel lbTitle;

    public Formulaire(String entity) throws SQLException, IOException, daoException, modelException {

        setTitle("Formulaire");
        setContentPane(panel);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocationRelativeTo(null);
        btnAccueil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControleurAccueil.init();
                dispose();
            }
        });

        if (entity.equals("CreateC")) {
            btnCreer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        int id = Integer.parseInt(sId.getText());
                        String raisonSocial = sRS.getText();
                        String numRue = sNumRue.getText();
                        String nomRue = sNomRue.getText();
                        String codePostal = sCP.getText();
                        String ville = sVille.getText();
                        String tel = sTel.getText();
                        String email = sMail.getText();
                        String commentaire = sCom.getText();
                        int chiffreAffaire = Integer.parseInt(sExtra1.getText());
                        int nbrEmploye = Integer.parseInt(sExtra2.getText());

                        ControleurFormulaire.creerClient(id, raisonSocial, numRue, nomRue, ville, codePostal, tel, email,
                                commentaire, chiffreAffaire, nbrEmploye);

                        JOptionPane.showMessageDialog(null, "Client crée avec succès");
                        ControleurAccueil.init();
                        dispose();

                    } catch (modelException ex) {
                        throw new RuntimeException(ex);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (daoException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
        }
        if (entity.equals("CreateP")){
            lbExtra1.setText("Date de Prospection");
            lbExtra2.setText("Intérêt");
            btnCreer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        int id = Integer.parseInt(sId.getText());
                        String raisonSocial = sRS.getText();
                        String numRue = sNumRue.getText();
                        String nomRue = sNomRue.getText();
                        String codePostal = sCP.getText();
                        String ville = sVille.getText();
                        String tel = sTel.getText();
                        String email = sMail.getText();
                        String commentaire = sCom.getText();
                        String date = sExtra1.getText();
                        String interet = sExtra2.getText();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate localDate = LocalDate.parse(date, formatter);

                        ControleurFormulaire.creerProspect(id,raisonSocial,numRue,nomRue,ville,codePostal,tel,email,
                                commentaire,interet,localDate);

                        JOptionPane.showMessageDialog(null,"Prospect crée avec succès");
                        ControleurAccueil.init();
                        dispose();

                    } catch (modelException ex) {
                        throw new RuntimeException(ex);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (daoException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
        }
        if (entity.equals("UpdateC")){
            lbTitle.setText("Update Client");
            sId.setText(String.valueOf(ControleurFormulaire.clientSelect.getIdentifiant()));
            sId.setEnabled(false);
            sRS.setText(ControleurFormulaire.clientSelect.getRaisonSociale());
            sNumRue.setText(ControleurFormulaire.clientSelect.getNumeroRue());
            sNomRue.setText(ControleurFormulaire.clientSelect.getNomRue());
            sVille.setText(ControleurFormulaire.clientSelect.getVille());
            sCP.setText(ControleurFormulaire.clientSelect.getCodePostal());
            sTel.setText(ControleurFormulaire.clientSelect.getTelephone());
            sMail.setText(ControleurFormulaire.clientSelect.getAdresseMail());
            sCom.setText(ControleurFormulaire.clientSelect.getCommentaire());
            sExtra1.setText(String.valueOf(ControleurFormulaire.clientSelect.getChiffreAffaire()));
            sExtra2.setText(String.valueOf(ControleurFormulaire.clientSelect.getNbrEmploye()));
            btnCreer.setText("Update");
            btnCreer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                    int id = Integer.parseInt(sId.getText());
                    String raisonSocial = sRS.getText();
                    String numRue = sNumRue.getText();
                    String nomRue = sNomRue.getText();
                    String codePostal = sCP.getText();
                    String ville = sVille.getText();
                    String tel = sTel.getText();
                    String email = sMail.getText();
                    String commentaire = sCom.getText();
                    int chiffreAffaire = Integer.parseInt(sExtra1.getText());
                    int nbrEmploye = Integer.parseInt(sExtra2.getText());
                        ControleurFormulaire.updateClient(id,raisonSocial,numRue,nomRue,ville,codePostal,tel,email,
                                commentaire,chiffreAffaire,nbrEmploye);
                        JOptionPane.showMessageDialog(null, "Client modifié avec succès");
                        ControleurAccueil.init();
                        dispose();
                    } catch (modelException ex) {
                        throw new RuntimeException(ex);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (daoException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

        }
        if (entity.equals("UpdateP")){
            lbTitle.setText("Update Prospect");
            sId.setText(String.valueOf(ControleurFormulaire.prospectSelect.getIdentifiant()));
            sId.setEnabled(false);
            sRS.setText(ControleurFormulaire.prospectSelect.getRaisonSociale());
            sNumRue.setText(ControleurFormulaire.prospectSelect.getNumeroRue());
            sNomRue.setText(ControleurFormulaire.prospectSelect.getNomRue());
            sVille.setText(ControleurFormulaire.prospectSelect.getVille());
            sCP.setText(ControleurFormulaire.prospectSelect.getCodePostal());
            sTel.setText(ControleurFormulaire.prospectSelect.getTelephone());
            sMail.setText(ControleurFormulaire.prospectSelect.getAdresseMail());
            sCom.setText(ControleurFormulaire.prospectSelect.getCommentaire());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            sExtra1.setText(ControleurFormulaire.prospectSelect.getDateProspection().format(formatter));
            sExtra2.setText(ControleurFormulaire.prospectSelect.getInteret());
            btnCreer.setText("Update");
            btnCreer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        int id = Integer.parseInt(sId.getText());
                        String raisonSocial = sRS.getText();
                        String numRue = sNumRue.getText();
                        String nomRue = sNomRue.getText();
                        String codePostal = sCP.getText();
                        String ville = sVille.getText();
                        String tel = sTel.getText();
                        String email = sMail.getText();
                        String commentaire = sCom.getText();
                        String date = sExtra1.getText();
                        String interer = sExtra2.getText();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate localDate = LocalDate.parse(date, formatter);

                        ControleurFormulaire.updateProspect(id,raisonSocial,numRue,nomRue,ville,codePostal,tel,email,
                                commentaire,interer,localDate);
                        JOptionPane.showMessageDialog(null, "Prospect modifié avec succès");
                        ControleurAccueil.init();
                        dispose();
                    } catch (modelException ex) {
                        throw new RuntimeException(ex);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (daoException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

        }


    }


}
