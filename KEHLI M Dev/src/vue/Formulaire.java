package vue;


import controleur.ControleurFormulaire;
import dao.daoException;
import model.modelException;
import utilities.DateFormat;
import utilities.MyLogg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;


/**
 * Interface Utlisateur pour afficher le formulaire de création, suppression et modification.
 */
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
    private JLabel lbInfo;
    private JCheckBox cbOui;
    private JCheckBox cbNon;

    public Formulaire(String entity){
        setTitle("Formulaire");
        setContentPane(panel);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocationRelativeTo(null);
        cbNon.setVisible(false);
        cbOui.setVisible(false);
        btnAccueil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControleurFormulaire.launchAccueil();
                dispose();
            }
        });

        if (entity.equals("CreateC")) {

            modifName();
            lbExtra1.setText("Chiffre d'affaire *");
            lbExtra2.setText("Nombre d'employé *");
            sId.setVisible(false);
            lbIdent.setVisible(false);
            btnCreer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (
                                sRS.getText().isEmpty() ||
                                sNumRue.getText().isEmpty() ||
                                sNomRue.getText().isEmpty() ||
                                sCP.getText().isEmpty() ||
                                sVille.getText().isEmpty() ||
                                sTel.getText().isEmpty() ||
                                sMail.getText().isEmpty() ||
                                sExtra1.getText().isEmpty() ||
                                sExtra2.getText().isEmpty()
                        ){
                            JOptionPane.showMessageDialog(null,
                                    "Tout les champs contenant la mention '*' doivent d'être remplis");
                        }
                        else {

                            String raisonSocial = sRS.getText();
                            String numRue = sNumRue.getText();
                            String nomRue = sNomRue.getText();
                            String codePostal = sCP.getText();
                            String ville = sVille.getText();
                            String tel = sTel.getText();
                            String email = sMail.getText();
                            String commentaire = sCom.getText();
                            double chiffreAffaire = Double.parseDouble(sExtra1.getText());
                            int nbrEmploye = Integer.parseInt(sExtra2.getText());

                            ControleurFormulaire.creerClient(1, raisonSocial, numRue, nomRue, ville, codePostal, tel, email,
                                    commentaire, chiffreAffaire, nbrEmploye);

                            JOptionPane.showMessageDialog(null, "Client crée avec succès");
                            ControleurFormulaire.launchAccueil();
                            dispose();
                        }

                    }
                    catch (daoException ex) {if (ex.getLevel()== Level.SEVERE){
                        MyLogg.LOGGER.log(Level.SEVERE,ex.getMessage());
                        JOptionPane.showMessageDialog(null,"Désolé une erreur s'est produite");
                        System.exit(1);
                    } else {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                    }catch (NumberFormatException ne){
                        JOptionPane.showMessageDialog(null,
                                "Des lettres ont été rentrés au mauvais endroits, " +
                                        "verifiez le chiffre d'affaire, l'id et le nombre d'employé");
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
            });
        }
        if (entity.equals("CreateP")){
            lbTitle.setText("Création Prospect");
            modifName();
            sId.setVisible(false);
            lbIdent.setVisible(false);
            lbExtra1.setText("Date de Prospection *");
            lbExtra2.setText("Intérêt *");
            sExtra2.setVisible(false);
            cbNon.setVisible(true);
            cbOui.setVisible(true);
            btnCreer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (
                                sRS.getText().isEmpty() ||
                                        sNumRue.getText().isEmpty() ||
                                        sNomRue.getText().isEmpty() ||
                                        sCP.getText().isEmpty() ||
                                        sVille.getText().isEmpty() ||
                                        sTel.getText().isEmpty() ||
                                        sMail.getText().isEmpty() ||
                                        sExtra1.getText().isEmpty() ||
                                        (!cbNon.isSelected() && !cbOui.isSelected())
                        ) {
                            JOptionPane.showMessageDialog(null,
                                    "Tout les champs contenant la mention '*' doivent d'être remplis");
                        } else {

                            String raisonSocial = sRS.getText();
                            String numRue = sNumRue.getText();
                            String nomRue = sNomRue.getText();
                            String codePostal = sCP.getText();
                            String ville = sVille.getText();
                            String tel = sTel.getText();
                            String email = sMail.getText();
                            String commentaire = sCom.getText();
                            String date = sExtra1.getText();
                            String interet;
                            if (cbOui.isSelected()) {
                                interet = "oui";
                            } else {
                                interet = "non";
                            }

                            LocalDate localDate = DateFormat.toLocalDate(date);

                            ControleurFormulaire.creerProspect(1, raisonSocial, numRue, nomRue, ville, codePostal, tel, email,
                                    commentaire, interet, localDate);

                            JOptionPane.showMessageDialog(null, "Prospect crée avec succès");
                            ControleurFormulaire.launchAccueil();
                            dispose();
                        }

                    }catch (modelException me){
                        JOptionPane.showMessageDialog(null,me.getMessage());
                    }
                    catch (daoException ex) {
                            if (ex.getLevel()== Level.SEVERE){
                                MyLogg.LOGGER.log(Level.SEVERE,ex.getMessage());
                                JOptionPane.showMessageDialog(null,"Désolé une erreur s'est produite");
                                System.exit(1);
                            } else {
                                JOptionPane.showMessageDialog(null,ex.getMessage());
                            }
                    }catch (NumberFormatException ne){
                        JOptionPane.showMessageDialog(null,
                                "Des lettres ont été rentrés au mauvais endroits verifiez l'id ");
                    }catch (DateTimeParseException de){
                        JOptionPane.showMessageDialog(null,
                                "Format date incorrect essayez avec le format : jj/mm/aaaa");
                    } catch (Exception ex){
                        MyLogg.LOGGER.log(Level.SEVERE,ex.getMessage());
                        JOptionPane.showMessageDialog(null,"Désolé une erreur s'est produite");
                        System.exit(1);
                    }
                }
            });
        }
        if (entity.equals("UpdateC")){
            lbTitle.setText("Update Client");
            lbInfo.setVisible(false);
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
            sExtra1.setText(Double.toString(ControleurFormulaire.clientSelect.getChiffreAffaire()));
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
                    Double chiffreAffaire = Double.valueOf(sExtra1.getText());
                    int nbrEmploye = Integer.parseInt(sExtra2.getText());
                        ControleurFormulaire.updateClient(id,raisonSocial,numRue,nomRue,ville,codePostal,tel,email,
                                commentaire,chiffreAffaire,nbrEmploye);
                        JOptionPane.showMessageDialog(null, "Client modifié avec succès");
                        ControleurFormulaire.launchAccueil();
                        dispose();
                    } catch (daoException ex) {if (ex.getLevel()== Level.SEVERE){
                        MyLogg.LOGGER.log(Level.SEVERE,ex.getMessage());
                        JOptionPane.showMessageDialog(null,"Désolé une erreur s'est produite");
                        System.exit(1);
                    } else {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                    }catch (NumberFormatException ne){
                        JOptionPane.showMessageDialog(null,
                                "Des lettres ont été rentrés au mauvais endroits, " +
                                        "verifiez le chiffre d'affaire, l'id et le nombre d'employé");
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
            });

        }
        if (entity.equals("UpdateP")){
            lbTitle.setText("Update Prospect");
            lbInfo.setVisible(false);
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
            sExtra1.setText(DateFormat.formatDate(ControleurFormulaire.prospectSelect.getDateProspection()));
            sExtra2.setVisible(false);
            cbOui.setVisible(true);
            cbNon.setVisible(true);
            if (ControleurFormulaire.prospectSelect.getInteret().equals("oui")){
                cbOui.setSelected(true);
            }else {
                cbNon.setSelected(true);
            }
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
                        String interet;
                        if (cbOui.isSelected()){
                            interet = "oui";
                        }else {
                            interet = "non";
                        }
                        LocalDate localDate = DateFormat.toLocalDate(date);

                        ControleurFormulaire.updateProspect(id,raisonSocial,numRue,nomRue,ville,codePostal,tel,email,
                                commentaire,interet,localDate);
                        JOptionPane.showMessageDialog(null, "Prospect modifié avec succès");
                        ControleurFormulaire.launchAccueil();
                        dispose();
                    }catch (daoException ex) {
                        if (ex.getLevel()== Level.SEVERE){
                            MyLogg.LOGGER.log(Level.SEVERE,ex.getMessage());
                            JOptionPane.showMessageDialog(null,"Désolé une erreur s'est produite");
                            System.exit(1);
                        } else {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                        }
                    }catch (NumberFormatException ne){
                        JOptionPane.showMessageDialog(null,
                                "Des lettres ont été rentrés au mauvais endroits verifiez l'id ");
                    }catch (DateTimeParseException de){
                        JOptionPane.showMessageDialog(null,
                                "Format date incorrect essayez avec le format : jj/mm/aaaa");
                    } catch (Exception ex){
                        MyLogg.LOGGER.log(Level.SEVERE,ex.getMessage());
                        JOptionPane.showMessageDialog(null,"Désolé une erreur s'est produite");
                        System.exit(1);
                    }
                }
            });

        }
        if (entity.equals("DeleteC")){
            lbTitle.setText("Delete Client");
            lbInfo.setVisible(false);
            sId.setText(String.valueOf(ControleurFormulaire.clientSelect.getIdentifiant()));
            notEnable();
            sRS.setText(ControleurFormulaire.clientSelect.getRaisonSociale());
            sNumRue.setText(ControleurFormulaire.clientSelect.getNumeroRue());
            sNomRue.setText(ControleurFormulaire.clientSelect.getNomRue());
            sVille.setText(ControleurFormulaire.clientSelect.getVille());
            sCP.setText(ControleurFormulaire.clientSelect.getCodePostal());
            sTel.setText(ControleurFormulaire.clientSelect.getTelephone());
            sMail.setText(ControleurFormulaire.clientSelect.getAdresseMail());
            sCom.setText(ControleurFormulaire.clientSelect.getCommentaire());
            sExtra1.setText(Double.toString(ControleurFormulaire.clientSelect.getChiffreAffaire()));
            sExtra2.setText(String.valueOf(ControleurFormulaire.clientSelect.getNbrEmploye()));
            btnCreer.setText("Supprimer");
            btnCreer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int supp = JOptionPane.showConfirmDialog(null,
                            "Êtes vous sur de vouloir supprimer ce Client");
                    if(supp == JOptionPane.YES_OPTION)
                    {
                        try {
                            ControleurFormulaire.deleteClient(ControleurFormulaire.clientSelect.getIdentifiant());
                            JOptionPane.showMessageDialog(null,"Client supprimé avec succés");
                            dispose();
                            ControleurFormulaire.launchAccueil();
                        }catch (daoException de){
                            if (de.getLevel()==Level.SEVERE){
                                JOptionPane.showMessageDialog(null,"Erreur de notre côté," +
                                        " Veuillez réssayer ultérieurement");
                                System.exit(1);
                                MyLogg.LOGGER.log(Level.SEVERE,de.getMessage());
                            } else {
                                JOptionPane.showMessageDialog(null,de.getMessage());
                            }
                        }
                        catch (Exception ex) {
                            JOptionPane.showMessageDialog(null,"Erreur de notre côté," +
                                    " Veuillez réssayer ultérieurement");
                            System.exit(1);
                            MyLogg.LOGGER.log(Level.SEVERE,ex.getMessage());
                        }
                    }
                    else ControleurFormulaire.launchAccueil();
                }
                });

        }
        if (entity.equals("DeleteP")){
            lbTitle.setText("Delete Prospect");
            lbInfo.setVisible(false);
            sId.setText(String.valueOf(ControleurFormulaire.prospectSelect.getIdentifiant()));
            notEnable();
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
            btnCreer.setText("Supprimer");
            btnCreer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int supp = JOptionPane.showConfirmDialog(null,
                            "Êtes vous sur de vouloir supprimer ce Prospect");
                    if(supp == JOptionPane.YES_OPTION)
                    {
                        try {
                            ControleurFormulaire.deleteProspect(ControleurFormulaire.prospectSelect.getIdentifiant());
                            JOptionPane.showMessageDialog(null,"Prospect supprimé avec succés");
                            dispose();
                            ControleurFormulaire.launchAccueil();
                        } catch (daoException de){
                            if (de.getLevel()==Level.SEVERE){
                                JOptionPane.showMessageDialog(null,"Erreur de notre côté," +
                                        " Veuillez réssayer ultérieurement");
                                System.exit(1);
                                MyLogg.LOGGER.log(Level.SEVERE,de.getMessage());
                            } else {
                                JOptionPane.showMessageDialog(null,de.getMessage());
                            }
                        }
                        catch (Exception ex) {
                            JOptionPane.showMessageDialog(null,"Erreur de notre côté," +
                                    " Veuillez réssayer ultérieurement");
                            System.exit(1);
                            MyLogg.LOGGER.log(Level.SEVERE,ex.getMessage());
                        }
                    }
                    else ControleurFormulaire.launchAccueil();
                }
            });
        }
    }

    private void notEnable(){
        sId.setEnabled(false);
        sRS.setEnabled(false);
        sCom.setEnabled(false);
        sMail.setEnabled(false);
        sTel.setEnabled(false);
        sExtra1.setEnabled(false);
        sExtra2.setEnabled(false);
        sVille.setEnabled(false);
        sNomRue.setEnabled(false);
        sNumRue.setEnabled(false);
        sCP.setEnabled(false);
    }
    private void modifName(){
        lbRS.setText("Raison Social *");
        lbCP.setText("Code Postal *");
        lbMail.setText("Adresse Mail *");
        lbNumRue.setText("Numéro de rue *");
        lnNomRue.setText("Nom de rue *");
        lbVille.setText("Ville *");
        lbTel.setText("Téléphone *");
    }


}
